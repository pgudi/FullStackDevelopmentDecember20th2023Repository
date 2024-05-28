package com.gentech.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gentech.security.entity.AuthenticationResponse;
import com.gentech.security.entity.User;
import com.gentech.security.repository.UserRepository;

@Service
public class AuthenticationService {
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(User request)
	{
		User user=new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());
		
		user=repository.save(user);
		String token=jwtService.generateToken(user);
		return new AuthenticationResponse(token);
	}
	
	public AuthenticationResponse authenticate(User request)
	{
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
					request.getUsername(), 
					request.getPassword())
		);
		
		User user=repository.findByUsername(request.getUsername()).get();
		String token=jwtService.generateToken(user);
		return new AuthenticationResponse(token);
	}
	
	

}
