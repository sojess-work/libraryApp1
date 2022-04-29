package com.sojess.libraryApp.DAO.Book;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookPublisherDAOImpl implements BookPublisherDAO {
	
private EntityManager entityManager;
	
	@Autowired
	public BookPublisherDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	public int getNumberOfBooksPublished(int publisherId) {
		//get the current hibernate session
				Session session = entityManager.unwrap(Session.class);
				
				Query q = session.createQuery("select count(*) from Book where publisher_id=:publisherId");
				q.setParameter("publisherId",publisherId);
			Long count =(Long)q.uniqueResult();
				
				return count.intValue();
	}

}
