package com.bookstore.obs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto 
{
     private int userId;
	private String uname;
	private String email;
	private String password;

}
