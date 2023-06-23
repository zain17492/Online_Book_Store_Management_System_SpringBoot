package com.bookstore.obs.service;

import java.util.List;

import com.bookstore.obs.dto.AuthorDto;

public interface AuthorService 
{
	//create
	AuthorDto createAuthor(AuthorDto authordto);
	
	//get
	AuthorDto getAuthor(long authorId);
	
	//get All
	List<AuthorDto> getAuthors();
	
	//update
	AuthorDto updateAuthor(AuthorDto authordto, long authorId);
	
	//delete
	 void deleteAuthor(long auhtorId);
	
}
