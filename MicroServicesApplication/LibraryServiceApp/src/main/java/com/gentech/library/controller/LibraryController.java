package com.gentech.library.controller;

import com.gentech.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.gentech.library.entity.Library;
import com.gentech.library.service.LibraryService;

@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {
	
	@Autowired
	private LibraryService libService;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping
	public Library saveLibrary(@RequestBody Library library)
	{
		return libService.saveLibrary(library);
	}
	

	@GetMapping("{id}")
	public Library getLibrary(@PathVariable Long id) throws Exception
	{
		Book book=restTemplate.getForObject("http://localhost:9093/api/v1/book/"+id, Book.class);
		Library library= libService.getLibraryById(id);
		library.setBook(book);
			
		return library;
	}
}
