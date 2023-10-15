package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.demo.bean.Book;

public class DataBase {

	ArrayList<Book> books = new ArrayList<Book>();

	public DataBase() {
		books.add(new Book(1, "HARRY POTTER Y EL PRISIONERO DE AZKABAN", "J.K ROWINS", "SALAMANDRA",
				"26/9/2006 0:00:00", "INFANTIL"));
		books.add(new Book(2, "EL GRAN LABERINTO", "FERNANDO SABATER PEREZ", "ARIEL", "26/9/2006 0:00:00", "FICCION"));
		books.add(
				new Book(3, "ROMEO Y JULIETA", "WILLIAM SHAKESPEARE", "SALAMANDRA", "26/9/2006 0:00:00", "ROMANTICA"));
		books.add(new Book(4, "LA CARTA ESFERICA", "ARTURO PAREZ LOPEZ", "SALAMANDRA", "29/9/2006 0:00:00", "FICCION"));
		books.add(new Book(5, "CODIGO DA VINCI", "DAN BROWN", "ARIEL", "29/9/2006 0:00:00", "FICCION"));
		books.add(new Book(6, "MUCHO RUIDO Y POCAS NUECES", "WILLIAM SHAKESPEARE", "SALAMANDRA", "26/9/2006 0:00:00",
				"ROMANTICA"));
		books.add(new Book(7, "PROTOCOLO", "JOSE LOPEZ MURILLO", "SALAMANDRA", "6/9/2006 0:00:00", "SOCIAL"));
		books.add(new Book(8, "LINUX", "FERNANDO SABATER PEREZ", "ARIEL", "6/9/2006 0:00:00", "INFORMATICA"));
		books.add(new Book(9, "EL TUMULTO", "H.P LOVERCRAFT", "DEBATE", "6/9/2006 0:00:00", "CIENCIA"));
		books.add(new Book(10, "PERSONAJES MITICONS", "RICHARD HOLLIGRAM", "DEBATE", "7/9/2006 0:00:00",
				"ENTRETENIMIENTO"));
		books.add(new Book(11, "THE TIME", "J.K ROWINS", "SALAMANDRA", "7/9/2006 0:00:00", "CIENCIA"));
		books.add(
				new Book(12, "DIETAS MEDITERRANEAS", "ARTURO PEREZ LOPEZ", "ARIEL", "16/9/2006 0:00:00", "ASTRONOMIA"));
		books.add(new Book(13, "ANGELES Y DEMONIOS", "DAN BROWN", "ARIEL", "6/10/2006 0:00:00", "FICCION"));
		books.add(new Book(14, "FORTALEZA DIGITAL", "DAN BROWN", "ARIEL", "6/10/2006 0:00:00", "FICCION"));
		books.add(new Book(15, "CAPITAN ALATRISTE", "ARTURO PEREZ LOPEZ", "ALFAGUARA", "9/10/2006 0:00:00", "FICCION"));
		books.add(new Book(16, "PIEL DE TAMBOR", "ARTURO PEREZ LOPEZ", "ALFAGUARA", "16/10/2006 0:00:00", "FICCION"));
		books.add(
				new Book(17, "TIEMPOS DE COLERA", "GABRIEL GARCIA GARCIA", "OVEJA NEGRA", "1/9/2006 0:00:00", "OSIO"));
		books.add(new Book(18, "NOTICIA DE UN SECUESTRO", "GABRIEL GARCIA GARCIA", "ALFAGUARA", "7/12/2006 0:00:00",
				"FICCION"));
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public void insert(Book book) {
		books.add(book);
	}

	public void delete(int id) {
		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			Book b = it.next();
			if (b.getId() == id) {
				it.remove();
				break;
			}
		}
	}

	public void modify(Book book) {
		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			Book b = it.next();
			if (b.getId() == book.getId()) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
				b.setEditorial(book.getEditorial());
				b.setDate(book.getDate());
				b.setTheme(book.getTheme());
				break;
			}
		}
	}

	public void getBook(int id) {
		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			Book b = it.next();
			if (b.getId() == id) {
				b.getTitle();
				b.getAuthor();
				b.getEditorial();
				b.getDate();
				b.getTheme();
				break;
			}
		}
	}
}
