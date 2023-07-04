package com.online.bsms.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bsms.dao.AuthorRepository;
import com.online.bsms.dto.AuthorDto;
import com.online.bsms.entities.Author;
import com.online.bsms.exception.ResourceNotFoundException;
import com.online.bsms.service.AuthorService;


@Service
public class AuthorServiceImpl implements AuthorService
{
	@Autowired
	private AuthorRepository autrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	@Override
	public AuthorDto createAuthor(AuthorDto authordto)
	{
		Author aut = this.modelmapper.map(authordto, Author.class);
		Author addedAuthor = this.autrepo.save(aut);
		return this.modelmapper.map(addedAuthor, AuthorDto.class);
	}
	
	//Get Author by id
	@Override
	public AuthorDto getAuthor(int authorId)
	{
		Author author = this.autrepo.findById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author", "author Id", authorId));
				return this.modelmapper.map(author, AuthorDto.class);
			}
	
	//Get all author
	@Override
	public List<AuthorDto> getAuthors() 
	{
		List<Author> authors =this.autrepo.findAll();
		 List<AuthorDto> authordtos =authors.stream().map(author ->this.authorToDto(author))
				 .collect(Collectors.toList());
		 return authordtos;
	}
	
	//update author
	@Override
	public AuthorDto updateAuthor(AuthorDto authordto, int authorId)
	{
		Author author = this.autrepo.findById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author", "author Id", authorId));
		
		author.setAname(authordto.getAname());

	
		Author updatedAuthor = this.autrepo.save(author);
		return this.modelmapper.map(updatedAuthor, AuthorDto.class);
	}
	
	//delete author
	@Override
	public void deleteAuthor(int auhtorId)  {
		Author author = this.autrepo.findById(auhtorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author", "author Id", auhtorId));
		this.autrepo.delete(author);
	}
	
	
	//convert Author to Dto
	public Author dtoToAuthor(AuthorDto authordto)
	{
		Author author= this.modelmapper.map(authordto, Author.class);
		
//		author.setAuthorId(authordto.getAuthorId());
//		author.setAname(authordto.getAname());
//		author.setEmail(authordto.getEmail());
		//author.setBooks(authordto.getBookId());
		return author;
		
	}
	
	//convert Dto to Author
	public AuthorDto authorToDto(Author author)
	{
		AuthorDto authordto = this.modelmapper.map(author, AuthorDto.class);
//		authordto.setAuthorId(author.getAuthorId());
//		authordto.setAname(author.getAname());
//		authordto.setEmail(author.getEmail());
		return authordto;
		
		
	}
	
}