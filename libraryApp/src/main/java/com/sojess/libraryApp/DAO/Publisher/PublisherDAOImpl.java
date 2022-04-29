package com.sojess.libraryApp.DAO.Publisher;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sojess.libraryApp.entity.Publisher;

@Repository
public class PublisherDAOImpl implements PublisherDAO{

private EntityManager entityManager;
	
	@Autowired
	public PublisherDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	public List<Publisher> getPublishers() {
Session session = entityManager.unwrap(Session.class);
		
		//get the publisher list
		Query<Publisher> q =  session.createQuery("from Publisher",Publisher.class);
		List<Publisher> publishers = q.getResultList();
		
		//return the publisher list
		return publishers;
	}

	@Override
	public Publisher getPublisherByPublisherId(int publisherId) {
	Session session = entityManager.unwrap(Session.class);
		
		//throw exeception if there is no publisher with the given id
		Publisher publisher= session.get(Publisher.class, publisherId);
		if(publisher==null) {
			throw new RuntimeException("No publisher with book id: "+publisherId);
		}
		
		//else return publisher
		return publisher;
	}

	@Override
	public int saveOrUpdatePublisher(Publisher publisher) {
Session session = entityManager.unwrap(Session.class);
		
		//saving/updating the Author
		session.saveOrUpdate(publisher);
		
		//returning author id for verification
		
		return (int)session.getIdentifier(publisher);
	}

	@Override
	public void deletePublisherById(int publisherId) {
		//get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//creating a query for deleting the author by id
		Query q = session.createQuery("delete from Publisher where id=:publisherId");
		q.setParameter("publisherId",publisherId);
		q.executeUpdate();

		
	}

	


}
