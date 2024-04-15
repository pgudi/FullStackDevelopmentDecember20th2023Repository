package com.gentech.emp.serviceimpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gentech.emp.dto.EmployeeDto;
import com.gentech.emp.entity.Employee;
import com.gentech.emp.mapper.EmployeeMapper;
import com.gentech.emp.repository.EmployeeRepository;
import com.gentech.emp.services.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepositopry;

	public EmployeeServiceImpl(EmployeeRepository employeeRepositopry) {
		super();
		this.employeeRepositopry = employeeRepositopry;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepositopry.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployee(Long id) {
		Employee employee=employeeRepositopry.findById(id).orElseThrow(() ->
		 new RuntimeException("The Employee id "+id+" does not exist!!!"));
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		Employee employee=employeeRepositopry.findById(id).orElseThrow(() ->
		 new RuntimeException("The Employee id "+id+" does not exist!!!"));
		
		
		employee.setEmpName(employeeDto.getEmpName());
		employee.setJobName(employeeDto.getJobName());
		employee.setAge(employeeDto.getAge());
		employee.setSalary(employeeDto.getSalary());
		employee.setEmailId(employeeDto.getEmailId());
		employee.setCityName(employeeDto.getCityName());
		
		Employee savedEmployee=employeeRepositopry.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto deleteEmployee(Long id) {
		Employee employee=employeeRepositopry.findById(id).orElseThrow(() ->
		 new RuntimeException("The Employee id "+id+" does not exist!!!"));
		
		EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDto(employee);
		employeeRepositopry.deleteById(id);
		return employeeDto;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		return employeeRepositopry.findAll().stream().map(
				(employee) -> EmployeeMapper.mapToEmployeeDto(employee))
		.collect(Collectors.toList());
		
	}
	
	@Override
	public EmployeeDto getEmployeeByName(String name) {
		Employee employee=employeeRepositopry.findByEmpName(name);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getEmployeesByCityName(String name) {
		return employeeRepositopry.findAllByCityName(name).stream().map(
				(employee) -> EmployeeMapper.mapToEmployeeDto(employee))
		.collect(Collectors.toList());
				
	}

	@Override
	public List<EmployeeDto> getEmployeesByJobAndCityName(String job, String city) {
		
		return employeeRepositopry.findAllByJobNameAndCityName(job, city).stream().map(
				(employee) -> EmployeeMapper.mapToEmployeeDto(employee))
		.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> getEmployeesByJobKeyword(String keyword) {
		
		return employeeRepositopry.findAllByJobNameContaining(keyword).stream().map(
				(employee) -> EmployeeMapper.mapToEmployeeDto(employee))
		.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> getEmployeesDetailsBySalary(double salary) {
		return employeeRepositopry.getEmployeesBySalary(salary).stream().map(
				(employee) -> EmployeeMapper.mapToEmployeeDto(employee))
		.collect(Collectors.toList());
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Employee employee=employeeRepositopry.findById(id).orElseThrow(() ->
		 new RuntimeException("The Employee id "+id+" does not exist!!!"));
		
		employeeRepositopry.deleteEmployeeById(id);
		
	}

	@Override
	public List<EmployeeDto> getAllEmployeesForPagination(int pageNumber, int pageSize) {
	//	Sort sort = Sort.by(Sort.Direction.DESC, "id");
		Pageable pages=PageRequest.of(pageNumber, pageSize, Direction.DESC, "id");
		
		return employeeRepositopry.findAll(pages).getContent().stream().map(
				(employee) -> EmployeeMapper.mapToEmployeeDto(employee))
		.collect(Collectors.toList());

	}

	@Override
	public List<EmployeeDto> getAllEmployeesWithSorting() {
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return employeeRepositopry.findAll(sort).parallelStream().toList().stream().map(
				(employee) -> EmployeeMapper.mapToEmployeeDto(employee))
		.collect(Collectors.toList());
	}
	
	
	
}
