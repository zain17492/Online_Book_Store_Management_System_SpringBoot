package com.bookstore.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.obs.dto.UserDto;
import com.bookstore.obs.entities.UsernamePass;
import com.bookstore.obs.security.CustomUserDetails;
import com.bookstore.obs.service.UserService;
import com.bookstore.security.JwtUtil;



@RestController
@RequestMapping("/home")
public class MainController {
	
	@Autowired
	private  DaoAuthenticationProvider aut;
	
	@Autowired
	private CustomUserDetails custom;
	
	
	private JwtUtil jwt;
	
	@Autowired
	private UserService userService;


	
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userdto)
	{
		UserDto registeredUser = this.userService.registerNewUser(userdto);
		return new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED);


	}	
	
	
	@PostMapping("/gettoken")
	public ResponseEntity<String> getToken(@RequestBody UsernamePass up)
	{	
		
		try {
			this.aut.authenticate(new UsernamePasswordAuthenticationToken(up.getUsername(), up.getPwd()));
		} 
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		UserDetails usr=this.custom.loadUserByUsername(up.getUsername());
		
		
		return ResponseEntity.ok(jwt.generateToken(usr));

	}
}
