package com.sojess.libraryApp.DAO.Author;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sojess.libraryApp.entity.Author;
import com.sojess.libraryApp.entity.Book;

@Repository
public class AuthorBookDAOImpl implements AuthorBookDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public AuthorBookDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	public Book getBookByAuthorIdBookId(int authorId,int bookId) {

		
		List<Book> books =this.getBooksByAuthorId(authorId);
		for(Book book:books) {
			if(book.getId()==bookId) {
				return book;
			}
		}
		return null;
		
	}

	@Override
	public List<Book> getBooksByAuthorId(int authorId) {
		//get the current hibernate session
				Session session = entityManager.unwrap(Session.class);
				
				//throw exeception if there is no author with the given id
				Author author= session.get(Author.class, authorId);
				if(author==null) {
					throw new RuntimeException("No author with id: "+authorId);
				}
				
				List<Book> books =author.getBooks();
				return books;
	}

}
