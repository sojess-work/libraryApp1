package com.sojess.libraryApp.DAO.Booking;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.sojess.libraryApp.entity.Billing;
import com.sojess.libraryApp.entity.Book;
import com.sojess.libraryApp.entity.Booking;
import com.sojess.libraryApp.entity.Customer;

@Repository
public class BookingDAOImpl implements BookingDAO {

	private EntityManager entityManager;
	
	@Autowired
	public BookingDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@Override
	public Booking getBookingDetailsByBookingId(int bookingId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Booking booking = session.get(Booking.class, bookingId);
		if(booking==null) {
			throw new RuntimeException("No book with book id: "+bookingId);
		}
		
		//else return book
		return booking;
	}
	@Override
	public int getCountofBooksByCustomerId(int customerId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query q = session.createQuery("select count(*) from Booking where customer_id=:customerId and is_returned=0");
		q.setParameter("customerId",customerId);
	Long count =(Long)q.uniqueResult();
		
		return count.intValue();
		
	}
	@Override
	public Billing bookReturnUpdate(int bookingId) {
		Session session = entityManager.unwrap(Session.class);
		
		Booking booking = session.get(Booking.class, bookingId);
		if(booking.getIsReturned()==1) {
			
			throw new RuntimeException("This book is already returned");
			
		}
			
		
		//setting is returned value to true
		
		
		//calculating no days the book is taken
		Date date1=booking.getBookingDate();
		Calendar cal = Calendar.getInstance();
		Date date2= cal.getTime();
		long diff = date2.getTime()-date1.getTime();
		long noOfDays= (diff/(1000*60*60*24))%365;
		
		
		Book book =booking.getTheBook();
		float price = book.getPrice();
		int bookCost=   (int) (price*0.005*noOfDays);
		System.out.println(bookCost);
		Customer customer = booking.getTheCustomer();
		String address = customer.getAddress();
		String state = customer.getState();
		Billing billing = new Billing();
		billing.setAddress(address);
		billing.setBillingState(state);
		billing.setBookingCost(bookCost);
		billing.setTheCustomerBill(customer);
		
		session.saveOrUpdate(billing);
		booking.setIsReturned(1);
		booking.setReturnDate(date2);
		session.saveOrUpdate(booking);
		return billing;
		
		
		
		
	}

}
