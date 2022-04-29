package com.sojess.libraryApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sojess.libraryApp.entity.Author;
import com.sojess.libraryApp.entity.Publisher;
import com.sojess.libraryApp.service.PublisherService;


@RestController
@RequestMapping("/api")
public class PublisherRestController {

	
	private PublisherService publisherService;
	@Autowired
	public PublisherRestController(PublisherService publisherService) {
		this.publisherService= publisherService;
	}
	
	@GetMapping("/publishers")
	public List<Publisher> getPublishers(){
		return publisherService.getPublishers();
	}
	
	@GetMapping("/publishers/{publisherId}")
	public String getPublisherByPublisherId(@PathVariable int publisherId){
		
		return publisherService.getPublisherByPublisherId(publisherId).toString();
	}
	
	@PostMapping("/publishers")
	public int savePublisher(@RequestBody Publisher publisher) {
		publisher.setId(0);
		return publisherService.saveOrUpdatePublisher(publisher);
	}
	
	@PutMapping("publishers")
	public int updatePublisher(@RequestBody Publisher publisher) {
		
		return publisherService.saveOrUpdatePublisher(publisher);
	}
	
	@DeleteMapping("/publishers/{publisherId}")
	public String  deletePublisher(@PathVariable int publisherId) {
		
		Publisher publisher = publisherService.getPublisherByPublisherId(publisherId);
		
		//checks if the author with the given id really exist in the table.
		if(publisher==null) {
			throw new RuntimeException("There is no user with id: "+publisherId);
			
		}
		//delete if the author exist
		publisherService.deletePublisherById(publisherId);
		return "Customer with id "+publisherId+" deleted!";
	}
}
