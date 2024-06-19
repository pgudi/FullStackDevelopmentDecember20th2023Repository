package com.gentech.student.controller;

import com.gentech.student.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.gentech.student.entity.Student;
import com.gentech.student.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping
	public Student createStudent(@RequestBody Student student)
	{
		return  studentService.saveStudent(student);
	}
	
	@GetMapping("{id}")
	public Student getStudent(@PathVariable Long id) throws Exception
	{
		Library library=restTemplate.getForObject("http://localhost:9092/api/v1/library/"+id, Library.class);
		Student student= studentService.getStudentById(id);
		student.setLibrary(library);
		return student;
	}
}
