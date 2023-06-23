package com.bookstore.obs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookDto 
{
	private Long bookId;
    private String bookname;
    private float price;
    private AuthorDto author;

}