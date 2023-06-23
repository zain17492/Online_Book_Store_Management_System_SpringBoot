package com.bookstore.obs.service;

import java.util.List;

import com.bookstore.obs.dto.BookDto;

public interface BookService 
{
	//create
	BookDto createBook(BookDto bookdto, long authorId);
	
	//get single college
	BookDto getBookById(long bookId);
	
	//Get all colleges
	List<BookDto> getAllBooks();
	
	//update
	BookDto updateBook(BookDto bookdto,long bookId);
	
	//delete
	void deleteBook(long bookId);
	
	//get all college by course
	List<BookDto> getBooksByAuthor(Long authorId);

}
