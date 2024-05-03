package com.gentech.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gentech.security.entity.MyUser;
import com.gentech.security.repository.MyUserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private MyUserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<MyUser> user=repository.findByUserName(username);
		MyUser userObj=user.get();
		if(user.isPresent())
		{
			return User
					.withUsername(userObj.getUserName())
					.password(userObj.getPassword())
					.roles(getRoles(userObj))
					.build();
		}
		else
		{
			throw new UsernameNotFoundException("The userName "+username+" has not found");
		}
		
	}

	public String[] getRoles(MyUser userObj)
	{
		if(userObj.getRole()==null)
		{
			return new String[] {"USER"};
		}
		else
		{
			return userObj.getRole().split(",");
		}
	}
	
}
