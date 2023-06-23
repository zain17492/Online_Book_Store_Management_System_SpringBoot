package com.bookstore.obs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.obs.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{

}
