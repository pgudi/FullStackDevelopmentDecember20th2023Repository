package com.gentech.unittesting.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gentech.unittesting.model.Student;

@DataJpaTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository repository;

	@Test
	@DisplayName("Saves the student details into database")
	public void save()
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));
		//Action
		Student savedStudent=repository.save(student1);
		//Assert
		assertThat(savedStudent).isNotNull();
		assertThat(savedStudent.getStudentName()).isEqualTo("Santosh");
	}

	@Test
	@DisplayName("display all student details from database")
	public void getStudents()
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));
		repository.save(student1);

		Student student2=new Student();
		student2.setStudentName("Aishwarya");
		student2.setEmailId("aishu@gss.com");
		student2.setCourseName("Computer Science");
		student2.setJoinDate(LocalDate.of(2021, 12, 24));
		repository.save(student2);

		//Action
		List<Student> newStudList=repository.findAll();

		//Assert
		assertThat(newStudList.size()).isEqualTo(2);
		assertThat(newStudList).isNotNull();
	}

	@Test
	@DisplayName("display a particular student details from database")
	public void getStudent()
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));
		Student savedStudent=repository.save(student1);
		Long id=savedStudent.getId();
		//Action
		Student studentrecord=repository.findById(id).get();
		//Assert
		assertThat(studentrecord).isNotNull();
		assertThat(studentrecord.getEmailId()).isEqualTo("santosh@gss.com");
	}
	@Test
	@DisplayName("delete a particular student details from database")
	public void delete()
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));
		repository.save(student1);

		Student student2=new Student();
		student2.setStudentName("Aishwarya");
		student2.setEmailId("aishu@gss.com");
		student2.setCourseName("Computer Science");
		student2.setJoinDate(LocalDate.of(2021, 12, 24));
		repository.save(student2);
		Long id2=student2.getId();
		//Action
		List<Student> list1=repository.findAll();
		repository.deleteById(id2);
		List<Student> list2=repository.findAll();
		//Assert
		assertThat(list2.size()).isNotEqualTo(list1.size());
	}
}
