package com.sojess.libraryApp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sojess.libraryApp.DAO.Author.AuthorBookDAO;
import com.sojess.libraryApp.DAO.Author.AuthorDAO;
import com.sojess.libraryApp.entity.Author;
import com.sojess.libraryApp.entity.Book;

@Service
public class AuthorServiceImpl implements AuthorService {

	private AuthorDAO authorDAO;
	private AuthorBookDAO authorBookDAO;
	
	@Autowired
	public AuthorServiceImpl(AuthorDAO authorDAO,AuthorBookDAO authorBookDAO) {
		this.authorDAO=authorDAO;
		this.authorBookDAO=authorBookDAO;
	}
	
	@Override
	@Transactional
	public List<Author> getAuthors() {
		
		return authorDAO.getAuthors();
	}

	@Override
	@Transactional
	public Author getAuthorByAuthorId(int bookId) {
		return authorDAO.getAuthorByAuthorId(bookId);
	}

	@Override
	@Transactional
	public Book getBookByAuthorIdBookId(int authorId, int bookId) {
		
		return authorBookDAO.getBookByAuthorIdBookId(authorId, bookId);
	}

	@Override
	@Transactional
	public List<Book> getBooksByAuthorId(int authorId) {
	
		return authorBookDAO.getBooksByAuthorId(authorId);
	}

	@Override
	@Transactional
	public int saveOrUpdateAuthor(Author author) {
		return authorDAO.saveOrUpdateAuthor(author);
	}

	@Override
	@Transactional
	public void deleteAuthorById(int id) {
		authorDAO.deleteAuthorById(id);
		
	}

}
