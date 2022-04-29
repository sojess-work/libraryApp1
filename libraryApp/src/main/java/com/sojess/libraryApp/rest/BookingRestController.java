package com.sojess.libraryApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sojess.libraryApp.entity.Billing;
import com.sojess.libraryApp.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingRestController {
	
	private BookingService bookingService;
	
	@Autowired
	public BookingRestController(BookingService bookingService) {
		this.bookingService=bookingService;
	}
	
	@GetMapping("/booking/return/{bookingId}")
	public Billing bookReturnUpdate(@PathVariable int bookingId) {
		return bookingService.bookReturnUpdate(bookingId);
	}
}
