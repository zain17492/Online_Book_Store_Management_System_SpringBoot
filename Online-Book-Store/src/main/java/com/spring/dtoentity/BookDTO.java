package com.spring.dtoentity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.spring.entity.Author;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	
	@NotEmpty
	private long bid;
	
	@Pattern(regexp = "^[A-Za-z0-9\\s]+$")
	@NotNull
	private String bname;
	
	private Author author;
	
	@Pattern(regexp = "\\d+")
	@NotEmpty
	private String price;

	

	public BookDTO(long bid, String bname, Author author, String price) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
	}

	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
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

