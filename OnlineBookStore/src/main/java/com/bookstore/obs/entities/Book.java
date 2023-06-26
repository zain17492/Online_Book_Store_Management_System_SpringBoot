package com.bookstore.obs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "books")
public class Book {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int bookId;

	    
	    @Column(name = "Book_name", nullable = false)
		@NotBlank(message = "Book Name can't be empty")
	    @NotNull(message = "Book Name  can't be  null")	
	    private String bookname;

	    @Column(name = "Price", nullable = false)
	    private float price;
	    
	    @ManyToOne
	    @JoinColumn(name="author_id")
	    private Author author;
		
	    }
