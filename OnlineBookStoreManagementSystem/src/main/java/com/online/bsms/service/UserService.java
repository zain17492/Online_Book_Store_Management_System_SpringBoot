package com.online.bsms.service;

import java.util.List;

import com.online.bsms.dto.UserDto;

public interface UserService 
{
	//register
    UserDto registerNewUser(UserDto userdto);
////create
//     UserDto createUser(UserDto userdto);
//	
	//get
     UserDto getUserById(int userId);
	
	//get All
	List<UserDto> getUsers();
	
	//update
	UserDto updateUser(UserDto userdto, int userId);
	
	//delete
	 void deleteUser(int userId);

}
