package com.sojess.libraryApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sojess.libraryApp.DAO.Book.BookPublisherDAO;
import com.sojess.libraryApp.DAO.Publisher.PublisherDAO;
import com.sojess.libraryApp.entity.Publisher;

@Service
public class PublisherServiceImpl implements PublisherService {
	
	private PublisherDAO publisherDAO;
	private BookPublisherDAO publisherBookDAO;
	
	@Autowired
	public PublisherServiceImpl(PublisherDAO publisherDAO,BookPublisherDAO publisherBookDAO) {
		this.publisherDAO=publisherDAO;
		this.publisherBookDAO=publisherBookDAO;
	}

	@Override
	@Transactional
	public List<Publisher> getPublishers() {
		
		return publisherDAO.getPublishers();
	}

	@Override
	@Transactional
	public Publisher getPublisherByPublisherId(int publisherId) {
		
		return publisherDAO.getPublisherByPublisherId(publisherId);
				}

	@Override
	@Transactional
	public int saveOrUpdatePublisher(Publisher publisher) {
		
		return publisherDAO.saveOrUpdatePublisher(publisher);
	}

	@Override
	@Transactional
	public void deletePublisherById(int pulisherId) {
		publisherDAO.deletePublisherById(pulisherId);
		
	}

	

}
