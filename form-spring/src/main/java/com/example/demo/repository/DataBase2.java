package com.example.demo.repository;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.demo.bean.Book;

public class DataBase2 {

	private Connection connection;

	public DataBase2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connect = "jdbc:mysql://localhost:3306/online_library";
			this.connection = DriverManager.getConnection(connect, "root", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(Book book) {
		String query = " insert into books (id, title, author, editorial, date, theme)" + "values (?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, book.getId());
			preparedStmt.setString(2, book.getTitle());
			preparedStmt.setString(3, book.getAuthor());
			preparedStmt.setString(4, book.getEditorial());
			preparedStmt.setString(5, book.getDate());
			preparedStmt.setString(6, book.getTheme());
			preparedStmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
	}

	public void delete(int id) {
		String query = "delete from books where id = " + id;

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
	}

	public void modify(Book book) {

		String query = " Update books set title=? , author=? , editorial=? , date=? , theme=? " + "where id=?";
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, book.getTitle());
			preparedStmt.setString(2, book.getAuthor());
			preparedStmt.setString(3, book.getEditorial());
			preparedStmt.setString(4, book.getDate());
			preparedStmt.setString(5, book.getTheme());
			preparedStmt.setInt(6, book.getId());
			System.out.print(preparedStmt.toString());

			preparedStmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
	}

	public Book getBook(int id) {
		Book book = null;
		try {
			java.sql.Statement s = connection.createStatement();
			String sql = "SELECT * FROM BOOKS WHERE ID = " + id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			rs.next();
			book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
		return book;
	}

	public ArrayList<Book> getBooks() {
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			java.sql.Statement s = connection.createStatement();
			String sql = "SELECT * FROM BOOKS";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				list.add(book);
			}
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
		return list;
	}

	public boolean checkUser(String user, String password) {
		boolean check = false;
		try {
			java.sql.Statement s = connection.createStatement();
			String sql = "SELECT count(*) FROM USERS WHERE user = '" + user + "'" + "and password='" + password + "'";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			rs.next();
			if (rs.getInt(1) > 0)
				check = true;
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
		return check;
	}

}
