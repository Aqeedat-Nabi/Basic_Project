package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Book;

@Service
public class DataBase3Service implements IDataBase3 {

	@Autowired
	DataBase3 bd;
	
	@Override
	public void insert(Book book) {
		bd.save(book);
	}

	@Override
	public void delete(int id) {
		bd.deleteById(id);
	}

	@Override
	public void modify(Book book) {
		bd.save(book);
	}

	@Override
	public Book getBook(int id) {
		java.util.Optional<Book> b = bd.findById(id);
		return b.get();
	}

	@Override
	public ArrayList<Book> getBooks() {
		return (ArrayList<Book>) bd.findAll();
	}

	@Override
	public boolean checkUser(String user, String password) {
		boolean check = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connect = "jdbc:mysql://localhost:3306/online_library";
			Connection connection = DriverManager.getConnection(connect,"root" , "");
			java.sql.Statement s = connection.createStatement();
			String sql = "SELECT count(*) FROM USERS WHERE user='" + user + "'"
					+ "and password='" + password + "'";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			rs.next();
			if (rs.getInt(1)>0) {
				check = true;
			}
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		return check;
	}
}
