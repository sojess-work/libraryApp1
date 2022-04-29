package com.sojess.libraryApp.service;

import java.util.List;

import com.sojess.libraryApp.entity.Publisher;


public interface PublisherService {

	public List<Publisher> getPublishers();
	
	public Publisher getPublisherByPublisherId(int publisherId);
	
	public int saveOrUpdatePublisher(Publisher publisher);
	
	public void deletePublisherById(int pulisherId);
	
	
}
