package com.sojess.libraryApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sojess.libraryApp.DAO.Booking.BookingDAO;
import com.sojess.libraryApp.entity.Billing;

@Service
public class BookingServiceImpl implements BookingService {

	private BookingDAO bookingDAO;
	
	@Autowired
	public BookingServiceImpl(BookingDAO bookingDAO) {
		this.bookingDAO=bookingDAO;
	}
	@Override
	@Transactional
	public Billing bookReturnUpdate(int bookingId) {
		
		return bookingDAO.bookReturnUpdate(bookingId);
	}

}
