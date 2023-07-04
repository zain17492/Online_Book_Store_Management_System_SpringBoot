package com.online.bsms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.bsms.dto.UserDto;
import com.online.bsms.exception.ApiResponse;
import com.online.bsms.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserController 
{
	@Autowired
	private UserService userservice;
	
	
		//Build Get User REST API
		@GetMapping("/{uid}")
		public ResponseEntity<UserDto> getUser(@PathVariable int uid)
		{
			UserDto userdto = this.userservice.getUserById(uid);
			return new ResponseEntity<UserDto>(userdto, HttpStatus.OK);
		}
		
		//Build Get All Author REST API
		@GetMapping("/getallUser")
		public ResponseEntity<List<UserDto>> getUsers()
		{
			List<UserDto> users = this.userservice.getUsers();
			return ResponseEntity.ok(users);
		}
		
		//Build Update author REST API
		@PutMapping("/updateUser/{uid}")
		public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userdto,@PathVariable int uid)
		{
			UserDto updatedUser = this.userservice.updateUser(userdto,uid);
			return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
		}
		
		//Build Delete Author REST API
		@PreAuthorize("hasRole('ADMIN')")
		@DeleteMapping("/deleteUser/{uid}")
		public ResponseEntity <ApiResponse> deleteUser(@PathVariable int uid)
		{
			this.userservice.deleteUser(uid);
			return new ResponseEntity<ApiResponse>(new ApiResponse ("user deleted successfully!.", true),HttpStatus.OK);
		}

}