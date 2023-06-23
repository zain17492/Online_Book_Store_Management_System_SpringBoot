package com.bookstore.obs.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.obs.dto.AuthorDto;
import com.bookstore.obs.exception.ApiResponse;
import com.bookstore.obs.service.AuthorService;
@RestController
@RequestMapping("/api/authors")
public class AuthorController 
{
	@Autowired
	private AuthorService as;
	
	
	//Build Add Course REST API
	@PostMapping("/")
	public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody AuthorDto authordto)
	{
		AuthorDto createAuthor = as.createAuthor(authordto);
		return new ResponseEntity<AuthorDto>(createAuthor, HttpStatus.CREATED);
	}
	
	//Build Get Author REST API
	@GetMapping("/{aid}")
	public ResponseEntity<AuthorDto> getCourse(@PathVariable Long aid)
	{
		AuthorDto authordto = this.as.getAuthor(aid);
		return new ResponseEntity<AuthorDto>(authordto, HttpStatus.OK);
	}
	
	//Build Get All Author REST API
	@GetMapping("/getallauthor")
	public ResponseEntity<List<AuthorDto>> getAuthors()
	{
		List<AuthorDto> authors = this.as.getAuthors();
		return ResponseEntity.ok(authors);
	}
	
	//Build Update author REST API
	@PutMapping("/{aid}")
	public ResponseEntity<AuthorDto> updateAuthor(@Valid @RequestBody AuthorDto authordto,@PathVariable Long aid)
	{
		AuthorDto updatedAuthor = this.as.updateAuthor(authordto,aid);
		return new ResponseEntity<AuthorDto>(updatedAuthor, HttpStatus.OK);
	}
	
	//Build Delete Author REST API
	@DeleteMapping("/{aid}")
	public ResponseEntity <ApiResponse> deleteCourse(@PathVariable Long aid)
	{
		this.as.deleteAuthor(aid);
		return new ResponseEntity<ApiResponse>(new ApiResponse ("author deleted successfully!.", true),HttpStatus.OK);
	}
	
	
	

}
