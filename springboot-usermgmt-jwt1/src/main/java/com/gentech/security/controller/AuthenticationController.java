package com.gentech.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gentech.security.entity.AuthenticationResponse;
import com.gentech.security.entity.User;
import com.gentech.security.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {
	@Autowired
	private AuthenticationService authService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody User request)
	{
		return new ResponseEntity<AuthenticationResponse>(authService.register(request), HttpStatus.CREATED);
	}

	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody User request)
	{
		return new ResponseEntity<AuthenticationResponse>(authService.authenticate(request), HttpStatus.OK);
	}
}
