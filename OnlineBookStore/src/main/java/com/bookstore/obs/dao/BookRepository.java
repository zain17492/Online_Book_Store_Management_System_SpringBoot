package com.bookstore.obs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.obs.entities.Author;
import com.bookstore.obs.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
	List<Book> findByAuthor(Author author);	

}
