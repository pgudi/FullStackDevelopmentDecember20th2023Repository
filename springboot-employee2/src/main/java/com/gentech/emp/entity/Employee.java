package com.gentech.emp.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "employee_name")
	private String empName;
	
	@Column(name = "employee_job_name")
	private String jobName;
	
	@Column(name = "employee_email_id")
	private String emailId;
	
	@Column(name = "employee_age")
	private int age;
	
	@Column(name = "employee_salary")
	private double salary;
	
	@Column(name = "employee_city_name")
	private String cityName;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	
	public Employee(Long id, String empName, String jobName, String emailId, int age, double salary, String cityName,
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
	
	public Employee(String empName, String jobName, String emailId, int age, double salary, String cityName,
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

	public Employee() {
		
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
