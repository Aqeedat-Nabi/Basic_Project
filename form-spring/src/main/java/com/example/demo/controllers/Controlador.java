package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.Book;
import com.example.demo.bean.User;
import com.example.demo.repository.DataBase3Service;

@Controller // we turn it into a servlet that serves http requests
@RequestMapping("")
public class Controlador {

//	DataBase bd = new DataBase();
//	DataBase2 bd = new DataBase2();
	User user;
	@Autowired
	DataBase3Service bd;

	@GetMapping("/")
	public String start(Model model) {
		model.addAttribute("title", "LOGIN FORM");
		return "login";
	}

	@PostMapping("/")
	public String login(User user, Model model) {
		if (user.getName().equals("espai") && user.getPassword().equals("123")) {
			ArrayList<Book> books =  bd.getBooks();
			model.addAttribute("user", user);
			this.user = user;
			model.addAttribute("books", books);
			return "consultation";
		} else
			return "login";
	}

	@PostMapping("/Insert")
	public String insert(Book book, Model model) {
		bd.insert(book);
		ArrayList<Book> books = bd.getBooks();
		model.addAttribute("user", this.user);
		model.addAttribute("books", books);
		model.addAttribute("button", "Insert Book");
		model.addAttribute("action", "/insert");
		model.addAttribute("book" , null);
		return "consultation";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		bd.delete(id);
		ArrayList<Book> books = bd.getBooks();
		model.addAttribute("books", books);
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Insert Book");
		model.addAttribute("action", "/delete");
		return "consultation";
	}

	@GetMapping("/modify/{id}")
	public String modify(@PathVariable int id, Model model) {

		Book book = bd.getBook(id);
		ArrayList<Book> books = bd.getBooks();
		model.addAttribute("books", books);
		model.addAttribute("book", book);
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Update Book");
		model.addAttribute("action", "/modify");
		return "consultation";
	}

	@PostMapping("/modify")
	public String modify2(Book book, Model model) {
		bd.insert(book);
		ArrayList<Book> books = bd.getBooks();
		model.addAttribute("user", this.user);
		model.addAttribute("books", books);
		model.addAttribute("book", null);
		model.addAttribute("button", "Insert Book");
		model.addAttribute("action", "/insert");
		return "consultation";
	}
}