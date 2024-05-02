package com.gentech.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/content")
public class ContentController {
	
	@GetMapping("/home")
	public String getHome()
	{
		return "It is a Home Page for Default Access";
	}
	
	@GetMapping("/admin/home")
	public String getAdminHome()
	{
		return "It is a Home Page for Admin User Access";
	}
	
	@GetMapping("/user/home")
	public String getUserHome()
	{
		return "It is a Home Page for Normal User Access";
	}

}
