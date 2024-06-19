package com.gentech.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gentech.book.entity.Book;
import com.gentech.book.service.BookService;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public Book createBook(@RequestBody Book book)
	{
		return bookService.saveBook(book);
	}
	
	@GetMapping("{id}")
	public Book getBook(@PathVariable Long id)
	{
		return bookService.getBookById(id);
	}

}
