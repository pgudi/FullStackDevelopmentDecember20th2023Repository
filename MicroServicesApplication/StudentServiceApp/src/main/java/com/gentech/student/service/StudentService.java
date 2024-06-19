package com.gentech.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.student.entity.Student;
import com.gentech.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public Student getStudentById(Long id) throws Exception
	{
		return studentRepository.findById(id).orElseThrow(() ->
		new Exception("Student id "+id+" has not found"));
	}
	
}
