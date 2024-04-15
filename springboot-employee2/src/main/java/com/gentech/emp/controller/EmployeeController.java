package com.gentech.emp.controller;

import java.util.List;

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

import com.gentech.emp.dto.EmployeeDto;
import com.gentech.emp.services.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
	{
		return new ResponseEntity<EmployeeDto>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id)
	{
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployee(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> modifyEmployee(@PathVariable("id") Long id,
			@RequestBody EmployeeDto employeeDto)
	{
		return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(id, employeeDto), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<EmployeeDto> deleteById(@PathVariable("id") Long id)
	{
		return new ResponseEntity<EmployeeDto>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees()
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/filterByName")
	public ResponseEntity<EmployeeDto> getEmployeeFilterByName(@RequestParam("name") String name) {
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/filterByCityName")
	public ResponseEntity<List<EmployeeDto>> getEmployeeFilterByCityName(@RequestParam("name") String name) {
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getEmployeesByCityName(name), HttpStatus.OK);
	}
	
	@GetMapping("/filterByJobAndCity")
	public ResponseEntity<List<EmployeeDto>> getEmployeesByJobAndCityName(
			@RequestParam("job") String job, @RequestParam("city") String city)
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getEmployeesByJobAndCityName(job, city), HttpStatus.OK);
	}
	
	@GetMapping("/keyword")
	public ResponseEntity<List<EmployeeDto>> getEmployeesByJobKeyword(@RequestParam("job") String job)
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getEmployeesByJobKeyword(job), HttpStatus.OK);
	}
	
	@GetMapping("/salary")
	public  ResponseEntity<List<EmployeeDto>> getAllEmployeesBySalary(@RequestParam("salary") double salary)
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getEmployeesDetailsBySalary(salary), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id)
	{
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("The Employee with id "+id+" delete succesfully!!", HttpStatus.OK);
	}
	
	@GetMapping("/pagination")
	public ResponseEntity<List<EmployeeDto>> getAllEmployeesPerPageWise(@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize)
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployeesForPagination(pageNumber, pageSize), HttpStatus.OK);
	}
	
	@GetMapping("/sort")
	public ResponseEntity<List<EmployeeDto>> getAllEmployeesBySorting()
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployeesWithSorting(), HttpStatus.OK);
	}
	
}
