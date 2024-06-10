package com.gentech.unittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.unittesting.model.Student;
import com.gentech.unittesting.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;

	public Student saveStudent(Student student)
	{
		return repository.save(student);
	}

	public List<Student> getAllStudents()
	{
		return repository.findAll();
	}

	public Student getStudentById(Long id) throws Exception
	{
		Student existingStudent=null;
		
			existingStudent= repository.findById(id).orElseThrow(() -> 
			new Exception("The Student id :"+id+" has not found"));
		
		return existingStudent;
	}
	
	public Student updateStudent(Student student, Long id)
	{
		Student existingStudent=null;
		try
		{
			existingStudent= repository.findById(id).orElseThrow(() -> 
			new Exception("The Student id :"+id+" has not found"));
			
			existingStudent.setId(id);
			existingStudent.setStudentName(student.getStudentName());
			existingStudent.setEmailId(student.getEmailId());
			existingStudent.setCourseName(student.getCourseName());
			existingStudent.setJoinDate(student.getJoinDate());
			
			repository.save(existingStudent);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return existingStudent;
	}
	
	public void deleteStudent(Long id)
	{
		try
		{
			Student existingStudent=repository.findById(id).orElseThrow(() -> 
			new Exception("The Student id :"+id+" has not found"));
			
			repository.delete(existingStudent);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	}

