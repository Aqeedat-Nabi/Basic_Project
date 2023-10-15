package com.example.demo.repository;

import java.util.ArrayList;

import com.example.demo.bean.Book;

public interface IDataBase3 {
	public void insert(Book book);

	public void delete(int id);

	public void modify(Book book);

	public Book getBook(int id);

	public ArrayList<Book> getBooks();

	public boolean checkUser(String user, String password);
}
