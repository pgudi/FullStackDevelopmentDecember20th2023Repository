package com.gentech.unittesting.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentech.unittesting.model.Student;
import com.gentech.unittesting.service.StudentService;
@WebMvcTest
public class StudentControllerTest {
	@MockBean
	private StudentService studentService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("Should Create uStudent in Database")
	public void createStudent() throws Exception
	{
		//Arrange
		Student student1=new Student();
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));

		//Action
		when(studentService.saveStudent(any(Student.class))).thenReturn(student1);

		this.mockMvc.perform(post("/api/v1/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(student1))

				).andExpect(status().isCreated())
		.andExpect(jsonPath("$.studentName", is(student1.getStudentName())))
		.andExpect(jsonPath("$.courseName", is(student1.getCourseName())));

	}

	@Test
	@DisplayName("Should display all Students from Database")
	public void displayAllStudents() throws Exception
	{

		//Arrange
		Student student1=new Student();
		student1.setId(1L);
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

		List<Student> list=new ArrayList<>();
		list.add(student1);
		list.add(student2);

		when(studentService.getAllStudents()).thenReturn(list);

		this.mockMvc.perform(get("/api/v1/students"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(list.size())));

	}

	@Test
	@DisplayName("Should display Speciific Student")
	public void displaySpecificStudent() throws Exception
	{
		//Arrange
		Student student1=new Student();
		student1.setId(1L);
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));

		when(studentService.getStudentById(anyLong())).thenReturn(student1);
		this.mockMvc.perform(get("/api/v1/students/{id}", 1L))
		.andExpect(status().isOk());

	}

	@Test
	@DisplayName("Should update Speciific Student")
	public void updateSpecificStudent() throws JsonProcessingException, Exception
	{
		//Arrange
		Student student1=new Student();
		student1.setId(1L);
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));

		when(studentService.updateStudent(any(Student.class), anyLong())).thenReturn(student1);
		student1.setCourseName("Master of Surgery");
		this.mockMvc.perform(put("/api/v1/students/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(student1))

				).andExpect(status().isOk())
		.andExpect(jsonPath("$.courseName", is(student1.getCourseName())));

	}

	@Test
	@DisplayName("Should delete Speciific Student")
	public void deleteSpecificStudent() throws Exception
	{
		//Arrange
		Student student1=new Student();
		student1.setId(1L);
		student1.setStudentName("Santosh");
		student1.setEmailId("santosh@gss.com");
		student1.setCourseName("Medical");
		student1.setJoinDate(LocalDate.of(2022, 10, 27));
		
		doNothing().when(studentService).deleteStudent(anyLong());
		
		this.mockMvc.perform(delete("/api/v1/students/{id}", 1L))
		.andExpect(status().isOk());
	}
}
