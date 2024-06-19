package com.gentech.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bookName;
	private String bookType;
	private String authorName;
	
	public Book() {
		
	}
	
	public Book(String bookName, String bookType, String authorName) {
		super();
		this.bookName = bookName;
		this.bookType = bookType;
		this.authorName = authorName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
