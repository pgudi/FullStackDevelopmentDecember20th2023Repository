package com.gentech.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.library.entity.Library;
import com.gentech.library.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;
	
	public Library saveLibrary(Library library)
	{
		return libraryRepository.save(library);
	}
	
	public Library getLibraryById(Long id) throws Exception
	{
		return libraryRepository.findById(id).orElseThrow(() -> new Exception("Library id "+id+" has not found"));
	}
}
