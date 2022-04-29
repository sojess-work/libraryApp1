package com.sojess.libraryApp.DAO.Publisher;

import java.util.List;

import com.sojess.libraryApp.entity.Publisher;

public interface PublisherDAO {

	public List<Publisher> getPublishers();
	
	public Publisher getPublisherByPublisherId(int publisherId);
	
	public int saveOrUpdatePublisher(Publisher publisher);
	
	public void deletePublisherById(int publisherId);
	
	
}
