package com.sojess.libraryApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="book")
public class Book {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="price")
	private float price;
	
	@Column(name="number_of_pages")
	private int numberOfPages;
	
	//bidrectional mapping as many books can be written by one author
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH,CascadeType.DETACH},fetch=FetchType.LAZY)
	@JoinColumn(name="author_id")
	@JsonBackReference(value="author-book")
	private Author theAuthor;
	
	//bidrectional mapping as many books can be published by one publisher
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH},fetch=FetchType.LAZY)
	@JoinColumn(name="publisher_id")
	@JsonBackReference(value="publisher-book")
	private Publisher thePublisher;
	
	@OneToMany(mappedBy = "theBook",cascade= {CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH,CascadeType.DETACH})
	@JsonManagedReference(value="book-booking")
	private List<Booking> bookings =new ArrayList<>();
	
	//constructors, getters and setters
	public Book() {
		
	}

	

	public Book(String name, String genre, float price, int numberOfPages) {
		this.name = name;
		this.genre = genre;
		this.price = price;
		this.numberOfPages = numberOfPages;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public int getNumberOfPages() {
		return numberOfPages;
	}



	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}


	



	public Author getTheAuthor() {
		return theAuthor;
	}



	public void setTheAuthor(Author theAuthor) {
		this.theAuthor = theAuthor;
	}



	public Publisher getThePublisher() {
		return thePublisher;
	}



	public void setThePublisher(Publisher thePublisher) {
		this.thePublisher = thePublisher;
	}



	public List<Booking> getBookings() {
		return bookings;
	}



	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

public void addBooking(Booking booking) {
		
		bookings.add(booking);
		booking.setTheBook(this);
	}
	
	public void removeBooking(Booking booking) {
		bookings.remove(booking);
		booking.setTheBook(null);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", genre=" + genre + ", price=" + price + ", numberOfPages="
				+ numberOfPages  + "]";
	}




	
}
