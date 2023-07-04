package com.online.bsms.controller;

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

import com.online.bsms.entities.UsernamePass;
import com.online.bsms.jwt.CustomUserDetails;
//import com.online.bsms.service.UserService;
import com.online.bsms.jwt.JwtUtil;

//@RestController
//@RequestMapping("/admin")
//public class MainController {
//	@Autowired
//	private  DaoAuthenticationProvider aut;
//	
//	@Autowired
//	private CustomUserDetails custom;
//	
//	@Autowired
//	private JwtUtil jwt;
//	
//	@PostMapping("/gettoken")
//	public ResponseEntity<String> getToken(@RequestBody UsernamePass id)
//	{
//		try {
//			this.aut.authenticate(new UsernamePasswordAuthenticationToken(id.getUsername(), id.getPwd()));
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//		}
//		UserDetails usr=this.custom.loadUserByUsername(id.getUsername());
//		return ResponseEntity.ok(jwt.generateToken(usr));
//	}
//	
//}

@RestController
@RequestMapping("/admins")
public class MainController {
	
	@Autowired
	private  DaoAuthenticationProvider aut;
	
	@Autowired
	private CustomUserDetails custom;
	
	@Autowired
	private JwtUtil jwt;
	
//	@Autowired
//	private UserService userService;
//

	
	
//	@PostMapping("/register")
//	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userdto)
//	{
//		UserDto registeredUser = this.userService.registerNewUser(userdto);
//		return new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED);
//
//
//	}	
//	
	
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
