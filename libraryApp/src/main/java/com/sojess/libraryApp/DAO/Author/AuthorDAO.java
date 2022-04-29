package com.sojess.libraryApp.DAO.Author;

import java.util.List;

import com.sojess.libraryApp.entity.Author;


public interface AuthorDAO {

	public List<Author> getAuthors();

	public Author getAuthorByAuthorId(int bookId);
	
	public int saveOrUpdateAuthor(Author author);
	
	public void deleteAuthorById(int id);
}
