package com.bookstore.obs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.obs.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>
{
	//public Author findById(int authorId);

}
