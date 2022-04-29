package com.sojess.libraryApp.DAO.Book;

import java.util.List;


import com.sojess.libraryApp.entity.Book;

public interface BookDAO {
	
	public List<Book> getBooks();

	public Book getBooksByBookId(int id);
	
	public int saveBook(Book book,int authorId,int publisherId);
	
	public int updateBook(Book book);

	public void deleteBookById(int bookId);



}
