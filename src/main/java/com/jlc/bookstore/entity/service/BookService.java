package com.jlc.bookstore.entity.service;

import java.util.List;

import org.hibernate.cfg.annotations.SetBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.jlc.bookstore.entity.Book;
import com.jlc.bookstore.entity.repo.BooksRepository;
import com.jlc.bookstore.model.BookDto;

@Service
public class BookService {

	@Autowired
	BooksRepository booksRepository;

	public Book createBook(BookDto book) {
		return booksRepository.save(
				new Book(book.getBookName(), book.getAuthor(), book.getPrice(), book.getCatagry(), book.getPublications()));
	}
	
	public List<Book> getBooks(Pageable pageable){
		List<Book> books = null;
		
		Page<Book> pages = booksRepository.findAll(pageable);
		books = pages.getContent();
		return books;
	}
	
	public Book addBook(Book book) {
		
		return booksRepository.save(book);
		
		
	}
	public Book addBookByID(String bookId) {
		
		 return booksRepository.findByBookId(bookId).get();
		
		
	}
	
	public long totalAvilableBooks() {
		return this.booksRepository.count();
	}

	public Book update(Book book, String bookId) {
		
		Book existingBook = booksRepository.findByBookId(bookId).get();
		existingBook.setAuthor(book.getAuthor());
		existingBook.setBookName(book.getBookName());
		existingBook.setCatagry(book.getCatagry());
		existingBook.setPrice(book.getPrice());
		existingBook.setPublications(book.getPublications());
		
		return booksRepository.save(existingBook);
	}
	
}
