package com.sojess.libraryApp.DAO.Author;

import java.util.List;

import com.sojess.libraryApp.entity.Book;

public interface AuthorBookDAO {

	public Book getBookByAuthorIdBookId(int authorId,int bookId);

	public List<Book> getBooksByAuthorId(int authorId);
}
