package com.gentech.tests.parameters;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Users {
	
	@Parameters(value="username")
	@Test(priority = 1)
	public void createUser(String username)
	{
		System.out.println("The user "+username+" has created successfully");
	}

	@Parameters(value="username")
	@Test(priority = 2)
	public void modifyUser(String username)
	{
		System.out.println("The user "+username+" has modified successfully");
	}
	
	@Test(priority = 3)
	public void deletUser()
	{
		System.out.println("The user demoUser1 has deleted successfully");
	}
	
	@BeforeClass
	public void setUp()
	{
		System.out.println("Launch Chrome Browser and Navigate URL and Login into the Application");
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("Logout from the Application and Close the Application");
		System.out.println("+++++++++++++++++++++++++++++++");
	}
}
