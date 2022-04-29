package com.sojess.libraryApp.service;


import java.util.List;

import com.sojess.libraryApp.entity.Author;
import com.sojess.libraryApp.entity.Book;



public interface AuthorService {
	
	public List<Author> getAuthors();

	public Author getAuthorByAuthorId(int bookId);
	
	public int saveOrUpdateAuthor(Author author);
	
	public void deleteAuthorById(int id);
	
	public List<Book> getBooksByAuthorId(int authorId);
	
	public Book getBookByAuthorIdBookId(int authorId, int bookId);
	
	

}
