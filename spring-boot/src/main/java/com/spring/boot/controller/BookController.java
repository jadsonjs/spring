/**
 * 
 */
package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boot.domain.Book;
import com.spring.boot.repository.BookRepository;

/**
 * This is a Spring MVC controller.
 * 
 * Have to stay under the "com.spring.boot" for spring find it.
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
@Controller
@RequestMapping("/books")  // all methods in the controller will start with /books
public class BookController {
	
	/**
	 * Use spring dependence injection the inject a implementation for this repository.
	 * 
	 * The Spring data create this implementation to us
	 */
	@Autowired
	private BookRepository bookRepository;
	
	
	/***
	 * Is somebody access the resource "/books" return to the page "listBooks.html";
	 * @return
	 */
	@GetMapping()
	public String list(){
		return "listBooks";
	}
	
	
	/**
	 * If someone make a post to  "/books" this method will be created.
	 * 
	 * @return
	 */
	@PostMapping("/create")  
	public String create(Book book){
		bookRepository.save(book);
		System.out.println("Book: "+book.getTitle()+ " create with sucess.");
		return "redirec:listBooks"; // reload this page
	}

}
