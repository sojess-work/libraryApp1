package com.sojess.libraryApp.service;

import java.util.List;


import com.sojess.libraryApp.entity.Book;

public interface BookService {

	public List<Book> getBooks();

	public Book getBooksByBookId(int id);

	public int saveBook(Book book,int authorId,int publisherId);
	
	public int updateBook(Book book);
	
	public void deleteBookById(int bookId);
	
	public int getNumberOfBooksPublished(int publisherId);
	
	public int getCountofBooksByCustomerId(int customerId);

}
