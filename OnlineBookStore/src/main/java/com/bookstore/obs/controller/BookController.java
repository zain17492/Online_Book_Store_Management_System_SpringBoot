package com.bookstore.obs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.obs.dto.BookDto;
import com.bookstore.obs.exception.ApiResponse;
import com.bookstore.obs.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController 
{
	@Autowired
	private BookService bookservice;

	
	
	@PostMapping("/author/{authorId}/books")
	public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookdto,
			                                        @PathVariable int authorId)
	{
		BookDto  createBook = this.bookservice.createBook(bookdto, authorId);
		return new ResponseEntity<BookDto>(createBook,HttpStatus.CREATED);
	}
	
	//get by author
	@GetMapping("/author/{authorId}/authors")
	public ResponseEntity<List<BookDto>> getBookByAuthor(@PathVariable int authorId)
	{
		List<BookDto> books = this.bookservice.getBooksByAuthor(authorId);
		return new ResponseEntity<List<BookDto>>(books,HttpStatus.OK);
	}
	
	//get all books
	@GetMapping("/getallBooks")
	public ResponseEntity<List<BookDto>> getAllBooks()
	{
		List<BookDto> allBooks = this.bookservice.getAllBooks();
		return new ResponseEntity<List<BookDto>>(allBooks,HttpStatus.OK);
		
	}
	// get book details by id
	@GetMapping("/getBook/{bookId}")
	public ResponseEntity<BookDto> getBookById(@PathVariable int bookId)
	{
		BookDto bookdto=this.bookservice.getBookById(bookId);
		return new ResponseEntity<BookDto>(bookdto,HttpStatus.OK);
		
	}
	
	//update book
	@PutMapping("/updateBooks/{bookId}")
	public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookdto,
			                                        @PathVariable int bookId)
	{
		BookDto updateBook = this.bookservice.updateBook(bookdto, bookId);
		return new ResponseEntity<BookDto>(updateBook,HttpStatus.OK);
	}
	
	//delete book
	@DeleteMapping("/deleteBooks/{bookId}")
	public ApiResponse deleteBook(@PathVariable int bookId)
	{
		this.bookservice.deleteBook(bookId);
		return new ApiResponse("Book is successfully deleted!", true);
	}
}
