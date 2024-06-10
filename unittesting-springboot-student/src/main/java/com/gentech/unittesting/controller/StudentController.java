package com.gentech.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gentech.unittesting.model.Student;
import com.gentech.unittesting.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllAvailableStudents()
	{
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getSpecificStudent(@PathVariable Long id) throws Exception
	{
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updateSpecificStudent(@RequestBody Student student,
			@PathVariable Long id)
	{
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSpecificStudent(@PathVariable Long id)
	{
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("The student with id "+id+" has deleted successfully", HttpStatus.OK);
	}
}
