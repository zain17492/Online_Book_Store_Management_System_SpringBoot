package com.bookstore.obs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.obs.entities.Author;
import com.bookstore.obs.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>
{
	List<Book> findByAuthor(Author author);	

}
