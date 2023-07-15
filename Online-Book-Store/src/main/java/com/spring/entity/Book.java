package com.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Book")
public class Book {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bid;
	
	@Pattern(regexp = "^[A-Za-z0-9\\s]+$")
	@NotNull
	private String bname;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Author author;
	
	@Pattern(regexp = "\\d+")
	private String price;

	// AllArgsConstructor
	public Book(@NotNull Long bid, @Pattern(regexp = "^[A-Za-z0-9\\s]+$") @NotNull String bname, Author author,
			@Pattern(regexp = "\\d+") String price) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
	}
	// NoArgsConstructor 
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getter Setter Method
	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
