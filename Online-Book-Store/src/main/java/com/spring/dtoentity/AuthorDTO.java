package com.spring.dtoentity;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.spring.entity.Book;

public class AuthorDTO {
	
	@NotEmpty
	private long aid;
	
	@Pattern(regexp = "^[A-Za-z0-9\\s]+$")
	@NotEmpty
	private String aname;
	
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	@NotEmpty
	private String aemail;
	
	private List<Book> book;

	public AuthorDTO(@NotEmpty long aid,String aname, String aemail,List<Book> book) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.aemail = aemail;
		this.book = book;
	}

	
	public AuthorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	
}
