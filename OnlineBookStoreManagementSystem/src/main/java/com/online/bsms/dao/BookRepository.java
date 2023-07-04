package com.online.bsms.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.bsms.entities.Author;
import com.online.bsms.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
	List<Book> findByAuthor(Author author);	

}