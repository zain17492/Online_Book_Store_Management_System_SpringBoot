package com.online.bsms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.online.bsms.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>
{
	//public Author findById(int authorId);
}