package com.bookstore.obs.service;

import java.util.List;

import com.bookstore.obs.dto.AuthorDto;

public interface AuthorService 
{
	//create
	AuthorDto createAuthor(AuthorDto authordto);
	
	//get
	AuthorDto getAuthor(int authorId);
	
	//get All
	List<AuthorDto> getAuthors();
	
	//update
	AuthorDto updateAuthor(AuthorDto authordto, int authorId);
	
	//delete
	 void deleteAuthor(int auhtorId);
	
}
