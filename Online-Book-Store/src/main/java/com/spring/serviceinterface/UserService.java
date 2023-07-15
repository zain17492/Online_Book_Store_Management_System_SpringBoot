package com.spring.serviceinterface;

import org.springframework.http.ResponseEntity;


import com.spring.entity.Users;


public interface UserService {
	
	ResponseEntity<String> registerUser(Users user);
	ResponseEntity<String> updateUser(Long uid,Users user);
}
