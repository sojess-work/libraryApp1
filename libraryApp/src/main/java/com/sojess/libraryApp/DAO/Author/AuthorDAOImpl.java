package com.sojess.libraryApp.DAO.Author;


import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sojess.libraryApp.entity.Author;



@Repository
public class AuthorDAOImpl implements AuthorDAO {

private EntityManager entityManager;
	
	@Autowired
	public AuthorDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	public List<Author> getAuthors() {
Session session = entityManager.unwrap(Session.class);
		
		//get the customers list
		Query<Author> q =  session.createQuery("from Author",Author.class);
		List<Author> authors = q.getResultList();
		
		//return the customers list
		return authors;
	}

	@Override
	public Author getAuthorByAuthorId(int bookId) {
		//get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//throw exeception if there is no book with the given id
		Author author= session.get(Author.class, bookId);
		if(author==null) {
			throw new RuntimeException("No book with book id: "+bookId);
		}
		
		//else return book
		return author;
	}

	@Override
	public int saveOrUpdateAuthor(Author author) {
		Session session = entityManager.unwrap(Session.class);
		
		//saving/updating the Author
		session.saveOrUpdate(author);
		
		//returning author id for verification
		
		return (int)session.getIdentifier(author);
	}

	@Override
	public void deleteAuthorById(int authorId) {
		//get the current hibernate session
				Session session = entityManager.unwrap(Session.class);
				
				//creating a query for deleting the author by id
				Query q = session.createQuery("delete from Author where id=:authorId");
				q.setParameter("authorId", authorId);
				q.executeUpdate();
		
	}

}
