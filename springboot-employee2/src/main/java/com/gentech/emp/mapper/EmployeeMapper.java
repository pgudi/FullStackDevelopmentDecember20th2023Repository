package com.gentech.emp.mapper;

import com.gentech.emp.dto.EmployeeDto;
import com.gentech.emp.entity.Employee;

public class EmployeeMapper {
	
	public static Employee mapToEmployee(EmployeeDto employeeDto)
	{
		Employee employee=new Employee(employeeDto.getId(),
				 employeeDto.getEmpName(),
				 employeeDto.getJobName(),
				 employeeDto.getEmailId(),
				 employeeDto.getAge(),
				 employeeDto.getSalary(),
				 employeeDto.getCityName(),
				 employeeDto.getCreatedAt(),
				 employeeDto.getUpdatedAt());
		return employee;
	}
	
	public static EmployeeDto mapToEmployeeDto(Employee employee)
	{
		EmployeeDto employeeDto=new EmployeeDto(employee.getId(),
				employee.getEmpName(),
				employee.getJobName(),
				employee.getEmailId(),
				employee.getAge(),
				employee.getSalary(),
				employee.getCityName(),
				employee.getCreatedAt(),
				employee.getUpdatedAt());
		return employeeDto;
	}

}
