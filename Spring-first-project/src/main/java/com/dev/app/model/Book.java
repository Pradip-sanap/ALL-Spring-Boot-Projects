package com.dev.app.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
	@Value("101")
	int bid;

	@Value("Ikigai")
	String bookname;

	public Book() {
		super();
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bookname=" + bookname + "]";
	}

	@PostConstruct
	public void initMethod() {
		System.out.println("Inside BOOK init method");
	}

	@PreDestroy
	public void destroyMethod() {
		System.out.println("Inside BOOK destroy method");
	}

}
