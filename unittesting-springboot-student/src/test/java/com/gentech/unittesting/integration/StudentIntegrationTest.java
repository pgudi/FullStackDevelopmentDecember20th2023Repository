package com.gentech.unittesting.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.gentech.unittesting.model.Student;
import com.gentech.unittesting.repository.StudentRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentIntegrationTest {

	@LocalServerPort
	private int port;

	private String baseUrl="http://localhost";

	private static RestTemplate restTemplate;

	@Autowired
	private StudentRepository studentRepository;

	@BeforeAll
	public static void init()
	{
		restTemplate= new RestTemplate();
	}

	@BeforeEach
	public void beforeEachTest()
	{
		baseUrl = baseUrl +":" +port+"/api/v1/students";
	}

	@AfterEach
	public void afterEachTest()
	{
		studentRepository.deleteAll();
	}

	@Test
	@DisplayName("Should Save Student Record")
	public void saveStudentTest()
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));

		Student saveStudent=restTemplate.postForObject(baseUrl, student1, Student.class);

		//Assert
		assertThat(saveStudent).isNotNull();
		assertThat(saveStudent.getStudentName()).isEqualTo("Santosh");

	}

	@Test
	@DisplayName("Should Display Specific Student")
	public void displaySpecificStudent()
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));

		student1=restTemplate.postForObject(baseUrl, student1, Student.class);

		Student existingStudent=restTemplate.getForObject(baseUrl+"/{id}", Student.class, student1.getId());
		//Assert
		assertThat(existingStudent).isNotNull();
		assertThat(existingStudent.getStudentName()).isEqualTo("Santosh");
	}

	@Test
	@DisplayName("Should Display All Students")
	public void displayAllStudents()
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));

		Student student2=new Student();
		student1.setId(2L);
		student2.setStudentName("Aishwarya");
		student2.setEmailId("aishu@gss.com");
		student2.setCourseName("Computer Science");
		student2.setJoinDate(LocalDate.of(2021, 12, 24));

		student1=restTemplate.postForObject(baseUrl, student1, Student.class);
		student2=restTemplate.postForObject(baseUrl, student2, Student.class);

		List<Student> list=restTemplate.getForObject(baseUrl, List.class);
		//Assert
		assertThat(list.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("Should Upfdate Specific Student")
	public void updateStudentTest()
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));

		student1=restTemplate.postForObject(baseUrl, student1, Student.class);

		student1.setCourseName("Master of Surgery");
		restTemplate.put(baseUrl+"/"+student1.getId(), student1, Student.class);

		Student modifiedStudent=restTemplate.getForObject(baseUrl+"/{id}", Student.class, student1.getId());

		//Assert
		assertThat(modifiedStudent).isNotNull();
		assertThat(modifiedStudent.getCourseName()).isEqualTo("Master of Surgery");

	}

	@Test
	@DisplayName("Should Delete Specific Student")
	public void deleteStudentTest()
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));

		Student student2=new Student();
		student1.setId(2L);
		student2.setStudentName("Aishwarya");
		student2.setEmailId("aishu@gss.com");
		student2.setCourseName("Computer Science");
		student2.setJoinDate(LocalDate.of(2021, 12, 24));

		student1=restTemplate.postForObject(baseUrl, student1, Student.class);
		student2=restTemplate.postForObject(baseUrl, student2, Student.class);
		
		int count=studentRepository.findAll().size();
		
		restTemplate.delete(baseUrl+"/"+student1.getId(), student1, Student.class);
		
		//Assert
		Assertions.assertEquals(count-1, studentRepository.findAll().size());
		
	}
}
