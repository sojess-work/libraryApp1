package com.sojess.libraryApp.DAO.Booking;

import com.sojess.libraryApp.entity.Billing;
import com.sojess.libraryApp.entity.Booking;

public interface BookingDAO {

	public int getCountofBooksByCustomerId(int customerId);

	public Billing bookReturnUpdate(int bookingId);
	
	public Booking getBookingDetailsByBookingId(int bookingId);
}
