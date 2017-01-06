/**
 * 
 */
package com.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
public class BookController {
	
	/***
	 * Is somebody access the resource "/books" return to the page "listBooks.html";
	 * @return
	 */
	@GetMapping("/books")
	public String list(){
		return "listBooks";
	}

}
