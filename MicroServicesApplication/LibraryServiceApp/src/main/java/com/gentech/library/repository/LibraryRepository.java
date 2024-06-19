package com.gentech.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gentech.library.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Long>{

}
