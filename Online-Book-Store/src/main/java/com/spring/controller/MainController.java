package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.entity.UsernamePass;
import com.spring.entity.Users;
import com.spring.jwt.CustomUserDetails;
import com.spring.jwt.JwtUtil;
import com.spring.service.UserServicesImpl;


@RestController
@CrossOrigin("*")
@RequestMapping("/admins")
public class MainController {
	
	@Autowired
	private  DaoAuthenticationProvider aut;
	
	@Autowired
	private CustomUserDetails custom;
	
	@Autowired
	private JwtUtil jwt;
	  
	
	@Autowired
	private UserServicesImpl userService;

	
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public ResponseEntity<String> adminLogin() {
		return ResponseEntity.ok("Admin Login");
	}
	
	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/user")
	public ResponseEntity<String> userLogin() {
		return ResponseEntity.ok("User Login");
	}
	
	
	@PostMapping("/reg")
	public ResponseEntity<String> userReg(@RequestBody Users user){
		return userService.registerUser(user);
	}
	
	
	
	@PostMapping("/gettoken")
	public ResponseEntity<String> getToken(@RequestBody UsernamePass up)
	{	
		
		try {
			this.aut.authenticate(new UsernamePasswordAuthenticationToken(up.getUsername(), up.getPassword()));
		} 
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		UserDetails usr=this.custom.loadUserByUsername(up.getUsername());
		
		
		return ResponseEntity.ok(jwt.generateToken(usr));

	}
}