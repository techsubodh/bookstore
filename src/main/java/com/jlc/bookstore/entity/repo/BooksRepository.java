package com.jlc.bookstore.entity.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jlc.bookstore.entity.Book;

public interface BooksRepository extends /*JpaRepository<Book, String>*/ PagingAndSortingRepository<Book, String>{

	Page<Book> findAll(Pageable pageable);
	
	Optional<Book> findByBookId(String ID);
}
