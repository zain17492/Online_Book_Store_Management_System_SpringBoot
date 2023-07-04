package com.online.bsms.controller;

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

import com.online.bsms.dto.AuthorDto;
import com.online.bsms.exception.ApiResponse;
import com.online.bsms.service.AuthorService;
@RestController
@RequestMapping("/Authors")
public class AuthorController 
{
	@Autowired
	private AuthorService as;
	
	
	//Build Add Course REST API
	@PostMapping("/addAuthor")
	public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody AuthorDto authordto)
	{
		AuthorDto createAuthor = as.createAuthor(authordto);
		return new ResponseEntity<AuthorDto>(createAuthor, HttpStatus.CREATED);
	}
	
	//Build Get Author REST API
	@GetMapping("/{aid}")
	public ResponseEntity<AuthorDto> getAuthor(@PathVariable int aid)
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
	@PutMapping("/updateAuthor/{aid}")
	public ResponseEntity<AuthorDto> updateAuthor(@Valid @RequestBody AuthorDto authordto,@PathVariable int aid)
	{
		AuthorDto updatedAuthor = this.as.updateAuthor(authordto,aid);
		return new ResponseEntity<AuthorDto>(updatedAuthor, HttpStatus.OK);
	}
	
	//Build Delete Author REST API
	@DeleteMapping("/deleteAuthor/{aid}")
	public ResponseEntity <ApiResponse> deleteAuthor(@PathVariable int aid)
	{
		this.as.deleteAuthor(aid);
		return new ResponseEntity<ApiResponse>(new ApiResponse ("author deleted successfully!.", true),HttpStatus.OK);
	}
	
	
	

}
