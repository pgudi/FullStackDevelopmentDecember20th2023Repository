package com.gentech.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.book.entity.Book;
import com.gentech.book.repository.BookRepository;
@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRespository;
	
	public Book saveBook(Book book)
	{
		return bookRespository.save(book);
	}
	
	public Book getBookById(Long id)
	{
		return bookRespository.findById(id).get();
	}

}
