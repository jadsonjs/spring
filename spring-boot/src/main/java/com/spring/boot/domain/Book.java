/**
 * 
 */
package com.spring.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a book in our system
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long isbn;
	
	private String title;
	
	private String author;

	public Book(){}
	
	/**
	 * @param isbn
	 * @param title
	 * @param author
	 */
	public Book(Long isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public Long getIsbn() {return isbn;}
	public String getTitle() {return title;}
	public String getAuthor() {return author;}
	public void setIsbn(Long isbn) {this.isbn = isbn;}
	public void setTitle(String title) {this.title = title;}
	public void setAuthor(String author) {this.author = author;}
	

}
