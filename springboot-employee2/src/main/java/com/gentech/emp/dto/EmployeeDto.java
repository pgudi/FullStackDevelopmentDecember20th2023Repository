package com.gentech.emp.dto;

import java.util.Date;
public class EmployeeDto {
	private Long id;

	private String empName;
	private String jobName;
	private String emailId;
	private int age;
	private double salary;
	private String cityName;
	private Date createdAt;
	private Date updatedAt;
	
	public EmployeeDto() {
		
	}
	public EmployeeDto(String empName, String jobName, String emailId, int age, double salary, String cityName,
			Date createdAt, Date updatedAt) {
		super();
		this.empName = empName;
		this.jobName = jobName;
		this.emailId = emailId;
		this.age = age;
		this.salary = salary;
		this.cityName = cityName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public EmployeeDto(Long id, String empName, String jobName, String emailId, int age, double salary, String cityName,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.empName = empName;
		this.jobName = jobName;
		this.emailId = emailId;
		this.age = age;
		this.salary = salary;
		this.cityName = cityName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
