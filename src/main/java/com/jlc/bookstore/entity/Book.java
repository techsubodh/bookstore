package com.jlc.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.jlc.bookstore.entity.id.generator.StudentIDGenerator;

@Entity
public class Book {

	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	  @GenericGenerator(
        name = "student_seq",
        strategy = "com.jlc.bookstore.entity.id.generator.StudentIDGenerator",
        parameters = {
	        @Parameter(name = StudentIDGenerator.INCREMENT_PARAM, value = "50"),
	        @Parameter(name = StudentIDGenerator.VALUE_PREFIX_PARAMETER, value = "JLC-"),
	        @Parameter(name = StudentIDGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
	  })
	String bookId;
	
	@Column
	String bookName;
	
	@Column
	String author;
	
	@Column
	double price;
	
	@Column
	String catagry;
	
	@Column
	String publications;

	
	public Book() {
		super();
		
	}


	public Book(String bookName, String author, double price, String catagry, String publications) {
		super();
		
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.catagry = catagry;
		this.publications = publications;
	}


	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCatagry() {
		return catagry;
	}


	public void setCatagry(String catagry) {
		this.catagry = catagry;
	}


	public String getPublications() {
		return publications;
	}


	public void setPublications(String publications) {
		this.publications = publications;
	}
	
	
	
}
