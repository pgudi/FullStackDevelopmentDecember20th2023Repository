package com.gentech.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gentech.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
