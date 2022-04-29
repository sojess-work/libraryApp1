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


import com.sojess.libraryApp.entity.Book;

import com.sojess.libraryApp.service.BookService;


@RestController
@RequestMapping("/api")
public class BookRestController {
	
	//Initializing service layers
	private BookService bookService;

	//autowiring the service layer dependency injection
	@Autowired
	public BookRestController(BookService bookService) {
		this.bookService= bookService;
		
	}
	
	//get list of all books in book table
	@GetMapping("/books")
	public List<Book> getBooks(){
		
		return bookService.getBooks();
	}
	
	//get details of  a book with bookid
	@GetMapping("/books/{bookId}")
	public String getBooksByBookId(@PathVariable int bookId){
		
		return bookService.getBooksByBookId(bookId).toString();
	}
	
	//adding a new book to the book table
	@PostMapping("/books/{authorId}/{publisherId}")
	public int saveBook(@RequestBody Book book,@PathVariable int authorId,@PathVariable int publisherId) {
		
		book.setId(0);
		return bookService.saveBook(book,authorId,publisherId);
	}
	
	//getting no of books based on publisherId
	@GetMapping("/books/countP/{publisherId}")
	public int  getNumberOfBooksPublished(@PathVariable int publisherId) {
		return bookService.getNumberOfBooksPublished(publisherId);
	}
	
	//updating a book in the book table
	@PutMapping("/books")
	public int updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	//deleting  a book in the book table
	@DeleteMapping("/books/{bookId}")
	public String  deleteCustomer(@PathVariable int bookId) {
		
		//check if the book with the given id is actually in the table
		Book book = bookService.getBooksByBookId(bookId);
		if(book==null) {
			throw new RuntimeException("There is no book with id: "+bookId);
			
		}
		bookService.deleteBookById(bookId);
		return "Book with id "+bookId+" deleted!";
	}
	@GetMapping("/books/countC/{customerId}")
	public int getCountofBooksByCustomerId(@PathVariable int customerId) {
		
		return bookService.getCountofBooksByCustomerId(customerId);
		
	}


}
