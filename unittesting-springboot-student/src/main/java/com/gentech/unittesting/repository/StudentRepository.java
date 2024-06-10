package com.gentech.unittesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gentech.unittesting.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
