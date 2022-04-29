package com.sojess.libraryApp.DAO.Book;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sojess.libraryApp.DAO.Author.AuthorDAO;
import com.sojess.libraryApp.DAO.Publisher.PublisherDAO;
import com.sojess.libraryApp.entity.Author;
import com.sojess.libraryApp.entity.Book;
import com.sojess.libraryApp.entity.Publisher;


@Repository
public class BookDAOImpl implements BookDAO {

private EntityManager entityManager;
	
	private AuthorDAO authorDAO;
	private PublisherDAO publisherDAO;
	@Autowired
	public BookDAOImpl(EntityManager entityManager,AuthorDAO authorDAO, PublisherDAO publisherDAO) {
		this.entityManager=entityManager;
		this.authorDAO=authorDAO;
		this.publisherDAO=publisherDAO;
	}
	//Querrying list of Books from books table
	@Override
	public List<Book> getBooks() {
		
		//get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//get the book list
		Query<Book> q =  session.createQuery("from Book",Book.class);
		List<Book> books = q.getResultList();
		
		//return the book list
		return books;
	}

	@Override
	public Book getBooksByBookId(int id) {
		
		//get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//throw exeception if there is no book with the given id
		Book book= session.get(Book.class, id);
		if(book==null) {
			throw new RuntimeException("No book with book id: "+id);
		}
		
		//else return book
		return book;
	}
	@Override
	public int updateBook(Book book) {
		//get the current hibernate session
				Session session = entityManager.unwrap(Session.class);
				
				//saving/updating the Customer
				session.saveOrUpdate(book);
				return (int)session.getIdentifier(book);
	}
	@Override
	public void deleteBookById(int bookId) {
		//get the current hibernate session
				Session session = entityManager.unwrap(Session.class);
				
				//creating a query for deleting the customer by id
				Query q = session.createQuery("delete from Book where id=:bookId");
				q.setParameter("bookId", bookId);
				q.executeUpdate();
		
	}
	@Override
	public int saveBook(Book book, int authorId,int publisherId) {
		
		Session session = entityManager.unwrap(Session.class);
		Author author = authorDAO.getAuthorByAuthorId(authorId);
		Publisher publisher = publisherDAO.getPublisherByPublisherId(publisherId);
		
		publisher.addBook(book);
		author.addBook(book);
		entityManager.persist(author);
		entityManager.merge(publisher);
		return (int)session.getIdentifier(book);
	}
	
	

}
