package com.gentech.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gentech.emp.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long>{
	
	Employee findByEmpName(String name);
	
	List<Employee> findAllByCityName(String name);
	
	//select * from employee where jobname='' and cityname='';
	List<Employee> findAllByJobNameAndCityName(String job,String city);
	
	//select * from employee where jobName like '%Sales%';
	List<Employee> findAllByJobNameContaining(String keyword);
	
	@Query("FROM Employee WHERE salary=:salary")
	List<Employee> getEmployeesBySalary(double salary);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Employee WHERE id=:id")
	Integer deleteEmployeeById(Long id);
	
}
