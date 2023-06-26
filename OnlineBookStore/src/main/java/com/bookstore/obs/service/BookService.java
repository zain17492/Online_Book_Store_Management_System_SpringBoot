package com.bookstore.obs.service;

import java.util.List;

import com.bookstore.obs.dto.BookDto;

public interface BookService 
{
	//create
	BookDto createBook(BookDto bookdto, int authorId);
	
	//get single college
	BookDto getBookById(int bookId);
	
	//Get all colleges
	List<BookDto> getAllBooks();
	
	//update
	BookDto updateBook(BookDto bookdto,int bookId);
	
	//delete
	void deleteBook(int bookId);
	
	//get all college by course
	List<BookDto> getBooksByAuthor(int authorId);

}
