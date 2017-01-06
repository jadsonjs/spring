/**
 * 
 */
package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.domain.Book;

/**
 * This class represents a repository of books
 * 
 * Using the spring data to create basic operation of CRUD.
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public interface BookRepository extends JpaRepository<Book, Long>{

}
