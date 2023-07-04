package com.online.bsms.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.online.bsms.dao.UserRepository;
import com.online.bsms.dto.UserDto;
import com.online.bsms.entities.User;
import com.online.bsms.exception.ResourceNotFoundException;
import com.online.bsms.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userepo;
	
	@Autowired
	private ModelMapper modelmapper;
	

	@Autowired
	private PasswordEncoder passwrodEncoder;
	
	@Override
	public UserDto registerNewUser(UserDto userdto) 
	{
		User user = this.modelmapper.map(userdto, User.class);
		
		//encoded the password
		user.setPassword(this.passwrodEncoder.encode(userdto.getPassword()));
		
		User users = this.userepo.save(user);
		return this.modelmapper.map(users, UserDto.class);
	}


	@Override
	public UserDto getUserById(int userId) {
		User user = this.userepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user Id", userId));
				return this.modelmapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getUsers() {
		List<User> users =this.userepo.findAll();
		 List<UserDto> userdtos =users.stream().map(user ->this.userToDto(user))
				 .collect(Collectors.toList());
		 return userdtos;
	}

	@Override
	public UserDto updateUser(UserDto userdto, int userId) {
		User user = this.userepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Userr", "userr Id", userId));
		
		user.setUname(userdto.getUname());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
	
		User updatedUser = this.userepo.save(user);
		return this.modelmapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(int userId) {
		User user = this.userepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user Id", userId));
		this.userepo.delete(user);
		
	}
	
	//convert User to Dto
		public User dtoToUser(UserDto userdto)
		{
			User user= this.modelmapper.map(userdto, User.class);
			return user;
			
		}
		
		//convert Dto to User
		public UserDto userToDto(User user)
		{
			UserDto userdto = this.modelmapper.map(user, UserDto.class);
			return userdto;
			
			
		}

		

}
