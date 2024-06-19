package com.gentech.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gentech.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	
}
