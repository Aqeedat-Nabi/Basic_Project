package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Book;

public interface DataBase3 extends JpaRepository<Book, Integer> {


	/*
	 * public void insert(Book book);
	 * 
	 * public void delete(int id);
	 * 
	 * public void modify(Book book);
	 * 
	 * public Book getBook(int id);
	 * 
	 * public ArrayList<Book> getBooks;
	 * 
	 * public boolean checkUser(String user, String password);
	 */
}
