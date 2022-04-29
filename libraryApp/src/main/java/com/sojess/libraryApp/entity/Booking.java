package com.sojess.libraryApp.entity;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="booking_id")
	private int id;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH,CascadeType.DETACH},fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	@JsonBackReference(value="customer-booking")
	private Customer theCustomer;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH,CascadeType.DETACH},fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	@JsonBackReference(value="book-booking")
	private Book theBook;
	
	@Column(name="booking_date")
	@DateTimeFormat(pattern="yyyy/mm/dd")
	private Date bookingDate;
	
	@Column(name="returning_date")
	@DateTimeFormat(pattern="yyyy/mm/dd")
	private Date returnDate;
	
	@Column(name="is_returned")
	private int isReturned;
	
	public Booking() {
		
	}

	public Booking(int columnId, Date bookingDate, Date returnDate, int isReturned) {
		
		this.bookingDate = bookingDate;
		this.returnDate = returnDate;
		this.isReturned = isReturned;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getIsReturned() {
		return isReturned;
	}

	public void setIsReturned(int isReturned) {
		this.isReturned = isReturned;
	}
	

	public Customer getTheCustomer() {
		return theCustomer;
	}

	public void setTheCustomer(Customer theCustomer) {
		this.theCustomer = theCustomer;
	}
	

	public Book getTheBook() {
		return theBook;
	}

	public void setTheBook(Book theBook) {
		this.theBook = theBook;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", columnId=" +   ", bookingDate=" + bookingDate + ", returnDate="
				+ returnDate + ", isReturned=" + isReturned + "]";
	}
	
	
}
