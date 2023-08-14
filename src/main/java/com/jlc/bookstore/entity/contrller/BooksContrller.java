package com.jlc.bookstore.entity.contrller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jlc.bookstore.entity.Book;
import com.jlc.bookstore.entity.service.BookService;

@RestController
@RequestMapping("/api")
public class BooksContrller {

	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<Book> getBooks(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "1") int size) {

		Pageable pageable = PageRequest.of(page, size);
		List<Book> books = bookService.getBooks(pageable);
		return new ResponseEntity(books, HttpStatus.OK);

	}
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<Book> getBooks(
			@PathVariable("bookId") String bookID ) {
	
		Book book = bookService.addBookByID(bookID);
		return new ResponseEntity(book, HttpStatus.OK);

	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody(required = true) Book book){
		
		
		return new ResponseEntity(bookService.addBook(book), HttpStatus.OK);
		
	}
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody(required = true) Book book, 
			@PathVariable("bookId") String bookID ){
		
		
		return new ResponseEntity(bookService.update(book, bookID), HttpStatus.OK);
		
	}
	
}
