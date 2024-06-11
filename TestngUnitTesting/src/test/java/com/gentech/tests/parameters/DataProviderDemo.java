package com.gentech.tests.parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	@Test(dataProvider = "userdata")
	public void createUser(String fname,String lname, String user, String courseName)
	{
		System.out.println(fname+" >> "+lname+" >> "+user+" >> "+courseName);
	}
	
	@DataProvider(name = "userdata")
	public Object[][] getUsersData()
	{
		return new Object[][] {{"demo1","user1","demoUser1","EEE"},
			{"demo2","user2","demoUser2","Civil"},
			{"demo3","user3","demoUser3","CSE"}};
	}

}
