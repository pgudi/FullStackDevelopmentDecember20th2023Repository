package com.gentech.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gentech.security.entity.MyUser;
import com.gentech.security.repository.MyUserRepository;

@RestController
@RequestMapping("/api/v1/content")
public class MyUserController {
	@Autowired
	private MyUserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register/user")
	public MyUser createUser(@RequestBody MyUser myuser)
	{
		myuser.setPassword(passwordEncoder.encode(myuser.getPassword()));
		return repository.save(myuser);
	}
}
