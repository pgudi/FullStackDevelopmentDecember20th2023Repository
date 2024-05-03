package com.gentech.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.gentech.security.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private MyUserDetailsService userDetailsService;
	/*
	@Autowired
	private PasswordEncoder passwordEncoder;
	*/
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(request ->{
					request.requestMatchers("/api/v1/content/home","api/v1/content/register/user").permitAll();
					request.requestMatchers("/api/v1/content/admin/**").hasRole("ADMIN");
					request.requestMatchers("/api/v1/content/user/**").hasRole("USER");
					request.anyRequest().authenticated();
				})
				.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
				.build();
	}
	/*
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails santu=User
				.withUsername("santu")
				.password(passwordEncoder().encode("welcome111"))
				.roles("ADMIN")
				.build();
		
		UserDetails gowri=User
				.withUsername("gowri")
				.password(passwordEncoder().encode("welcome111"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(santu, gowri);
	}
	*/
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		return userDetailsService;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
