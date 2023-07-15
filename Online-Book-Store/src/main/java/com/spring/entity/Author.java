package com.spring.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long aid;
	
	@Pattern(regexp = "^[A-Za-z\\s]+$")
	@NotNull
	private String aname;
	
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	@NotNull
	private String aemail;
	
	@OneToMany(mappedBy = "author")
	@JsonManagedReference
	private List<Book> book;

	// AllArgsConstructor
	public Author(Long aid, String aname,String aemail,List<Book> book) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.aemail = aemail;
		this.book = book;
	}

	// NoArgsConstructor  
	public Author() {
		super();
	}

	//Getter Setter Method
	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
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
