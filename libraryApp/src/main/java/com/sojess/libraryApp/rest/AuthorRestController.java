package com.sojess.libraryApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sojess.libraryApp.entity.Author;
import com.sojess.libraryApp.entity.Book;
import com.sojess.libraryApp.service.AuthorService;


@RestController
@RequestMapping("/api")
public class AuthorRestController {
	
	//Initializing service layer
	private AuthorService authorService;
	
	//autowiring service layer for dependency injection
	@Autowired
	public AuthorRestController(AuthorService authorService) {
		this.authorService= authorService;
	}
	
	//Retrieve all authors from author table with books details too!
	@GetMapping("/authors")
	public List<Author> getAuthors(){
		
		return authorService.getAuthors();
	}
	
	//Retrieve only author details with given id
	@GetMapping("/authors/{authorId}")
	public String getAuthorByAuthorId(@PathVariable int authorId){
		
		return authorService.getAuthorByAuthorId(authorId).toString();
	}
	
	//retrieve book details written by a specific author by author id and book id
	@GetMapping("/authors/{authorId}/{bookId}")
	public Book getBookByAuthorIdBookId(@PathVariable int authorId,@PathVariable int bookId){
		
		return authorService.getBookByAuthorIdBookId(authorId,bookId);
	}
	
	//retrieve all the books written by a author by authorid
	@GetMapping("/author/books/{authorId}")
	public List<Book> getBooksByAuthorId(@PathVariable int authorId){
		
		return authorService.getBooksByAuthorId(authorId);
	}
	
	//add a new author
	@PostMapping("/authors")
public int saveAuthor(@RequestBody Author author) {
		author.setId(0);
		return authorService.saveOrUpdateAuthor(author);
	}
	
	//update  author details
	@PutMapping("/authors")
	public int updateAuthor(@RequestBody Author author) {
		
		return authorService.saveOrUpdateAuthor(author);
	}
	
	//delete author, only works if the author is not referenced in the book table
	//authors referenced in the book table cannot be deleted
	@DeleteMapping("/authors/{authorId}")
	public String  deleteAuthor(@PathVariable int authorId) {
		
		Author author = authorService.getAuthorByAuthorId(authorId);
		
		//checks if the author with the given id really exist in the table.
		if(author==null) {
			throw new RuntimeException("There is no user with id: "+authorId);
			
		}
		//delete if the author exist
		authorService.deleteAuthorById(authorId);
		return "Customer with id "+authorId+" deleted!";
	}
}
