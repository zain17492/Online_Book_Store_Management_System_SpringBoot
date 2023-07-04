package com.online.bsms.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="author")
public class Author
{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int authorId;
	
	@Column(name="Author_Name")
	@NotBlank(message = "Author Name can't be empty")
    @NotNull(message = "Author Name  can't be  null")
	private String aname;
	
	
	
	@OneToMany(mappedBy="author",cascade=CascadeType.ALL,fetch =FetchType.LAZY)
	private List<Book> books ;

}
