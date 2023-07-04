package com.online.bsms.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bsms.dao.AuthorRepository;
import com.online.bsms.dao.BookRepository;
import com.online.bsms.dto.BookDto;
import com.online.bsms.entities.Author;
import com.online.bsms.entities.Book;
import com.online.bsms.exception.ResourceNotFoundException;
import com.online.bsms.service.BookService;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	private BookRepository bookrepo;
	
	@Autowired
	private AuthorRepository authorrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	//create book
	@Override
	public BookDto createBook(BookDto bookdto, int authorId) 
	{
		Author author = this.authorrepo.findById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author", "author Id", authorId));
		
		Book book = this.modelmapper.map(bookdto, Book.class);
		book.setAuthor(author);
		Book newBook= this.bookrepo.save(book);
		return this.modelmapper.map(newBook, BookDto.class);
	}
	
	
	//get book by author
	@Override
	public List<BookDto> getBooksByAuthor(int authorId) 
	{
		Author aut = this.authorrepo.findById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author", "author Id", authorId));
		
		List<Book> books = this.bookrepo.findByAuthor(aut);
		
		List<BookDto>  bookdtos =books.stream().map((book) -> this.modelmapper.map(book, BookDto.class))
				.collect(Collectors.toList());

		return bookdtos;
	}

	//get all books
	@Override
	public List<BookDto> getAllBooks()
	{
		List<Book> allBooks = this.bookrepo.findAll();
		List<BookDto> bookdtos= allBooks.stream().map((book) -> this.modelmapper.map(book, BookDto.class))
		                                           .collect(Collectors.toList());
		return bookdtos;
	}
	
	//get book by id
	@Override
	public BookDto getBookById(int bookId) 
	{
		Book book = this.bookrepo.findById(bookId)
		.orElseThrow(() -> new ResourceNotFoundException("Book", "book Id", bookId));
		
		return this.modelmapper.map(book, BookDto.class);
	}

	//get book deatils by name
//	public  BookDto getBookName(String bookname)
//	{
//		Book book = this.bookrepo.getByName(bookname)
//				.orElseThrow(() -> new ResourceNotFoundException("Book", "book name", bookname));
//		return this.modelmapper.map(book, BookDto.class);
//					
//	}
	//update book details
	@Override
	public BookDto updateBook(BookDto bookdto, int bookId)
	{
		Book book = this.bookrepo.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "book Id", bookId));
		book.setBookname(bookdto.getBookname());
		book.setPrice(bookdto.getPrice());
		
		Book updatedBook = this.bookrepo.save(book);
		return this.modelmapper.map(updatedBook, BookDto.class);
	}
	
	//delete book
		@Override
		public void deleteBook(int bookId) 
		{
			Book book = this.bookrepo.findById(bookId)
			.orElseThrow(() -> new ResourceNotFoundException("Book", "book Id", bookId));
			
			this.bookrepo.delete(book);	
		}
		
		public Book dtoToBook(BookDto bookdto)
		{
			Book book= this.modelmapper.map(bookdto, Book.class);
//			book.setBookId(bookdto.getBookId());
//			book.setBookname(bookdto.getBookname());
			//book.setAuthor(bookdto.getAuthor());
			return book;	
		}
		
		public BookDto bookToDto(Book book)
		{
			BookDto bookdto = this.modelmapper.map(book, BookDto.class);
//			bookdto.setBookId(book.getBookId());
//			bookdto.setBookname(book.getBookname());
//			bookdto.setPrice(book.getPrice());
			return bookdto;
			
			
		}

}
