package com.gentech.unittesting.service;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gentech.unittesting.model.Student;
import com.gentech.unittesting.repository.StudentRepository;
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
	@InjectMocks
	private StudentService studentService;

	@Mock
	private StudentRepository repository;

	@Test
	@DisplayName("Should Save the Student object")
	public void save()
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));

		//Action
		when(repository.save(any(Student.class))).thenReturn(student1);

		Student savedStudent=studentService.saveStudent(student1);

		//Assert
		assertThat(savedStudent).isNotNull();
		assertThat(savedStudent.getStudentName()).isEqualTo("Santosh");

	}

	@Test
	@DisplayName("Should have students count 2")
	public void getStudents()
	{
		//Arrange
		Student student1=new Student();
		student1.setId(1L);
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));
		repository.save(student1);

		Student student2=new Student();
		student1.setId(2L);
		student2.setStudentName("Aishwarya");
		student2.setEmailId("aishu@gss.com");
		student2.setCourseName("Computer Science");
		student2.setJoinDate(LocalDate.of(2021, 12, 24));
		repository.save(student2);

		List<Student> list=new ArrayList<>();
		list.add(student1);
		list.add(student2);
		//Action
		when(repository.findAll()).thenReturn(list);

		List<Student> students=studentService.getAllStudents();

		//Assert
		assertThat(students).isNotNull();
		assertThat(students.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("Should display the Particular Student")
	public void getStudentByParticularId() throws Exception
	{
		//Arrange
		Student student1=new Student();
		student1.setId(1L);
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));
		repository.save(student1);
		//Action
		when(repository.findById(anyLong())).thenReturn(Optional.of(student1));
		
		Student existingStudent=studentService.getStudentById(1L);
		//Assert
		assertThat(existingStudent).isNotNull();
		assertThat(existingStudent.getId()).isEqualTo(1L);
	}

	@Test()
	@DisplayName("Should display the Run Time Exception")
	public void getStudentWithException()
	{
		//Arrange
		Student student1=new Student();
		student1.setId(1L);
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));
		repository.save(student1);
		//Action
		when(repository.findById(1L)).thenReturn(Optional.of(student1));
		Assertions.assertThrows(Exception.class, () -> {
			studentService.getStudentById(12L);
		});
	}
	
	@Test
	@DisplayName("Should update the Student object")
	public void updateStudentRecord()
	{
		//Arrange
		Student student1=new Student();
		student1.setId(1L);
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));

		//Action
		when(repository.findById(1L)).thenReturn(Optional.of(student1));
		when(repository.save(any(Student.class))).thenReturn(student1);

		student1.setEmailId("santoshbhaskar@gmail.com");
		Student updatedStudent=studentService.updateStudent(student1,1L);

		//Assert
		assertThat(updatedStudent).isNotNull();
		assertThat(updatedStudent.getEmailId()).isEqualTo("santoshbhaskar@gmail.com");

	}
	
	@Test
	@DisplayName("Should Delete the Particular Student object")
	public void deleteParticularStudent()
	{
		//Arrange
		Student student1=new Student();
		student1.setId(1L);
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));
		repository.save(student1);
		Long id1=1L;
		//Action
		when(repository.findById(anyLong())).thenReturn(Optional.of(student1));
		doNothing().when(repository).delete(any(Student.class));
		
		studentService.deleteStudent(id1);
		//Assert
		verify(repository, times(1)).delete(student1);

	}
	
}
