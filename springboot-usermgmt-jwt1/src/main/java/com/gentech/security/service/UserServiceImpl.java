package com.gentech.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gentech.security.repository.UserRepository;
@Service
public class UserServiceImpl implements UserDetailsService{
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User "+username+" has not found!!!"));
	}

}
