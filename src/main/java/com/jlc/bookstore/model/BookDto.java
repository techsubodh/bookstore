package com.jlc.bookstore.model;

public class BookDto {

	int bookId;

	String bookName;

	String author;

	double price;

	String catagry;

	String publications;

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public String getCatagry() {
		return catagry;
	}

	public String getPublications() {
		return publications;
	}

	public BookDto(String bookName, String author, double price, String catagry, String publications) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.catagry = catagry;
		this.publications = publications;
	}
	
	

}
