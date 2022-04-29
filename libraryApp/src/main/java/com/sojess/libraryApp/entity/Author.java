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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="author") 
public class Author {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	//creating a one to many mapping as one author can write many different books
	//jsonmanaged refference is used to avoid json loop value is used as there is multiple json references in
	//in the book entity.
	@OneToMany(mappedBy = "theAuthor",cascade= {CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH,CascadeType.DETACH})
	@JsonManagedReference(value="author-book")
	private List<Book> books =new ArrayList<>();
	
	//constructors, getters and setters
	public Author() {
		
	}

	public Author(String name, String address, String country, String state, String email, String phone) {

		this.name = name;
		this.address = address;
		this.country = country;
		this.state = state;
		this.email = email;
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
//when the below codes are added to the program while accessing /api/books endpoint infinity array is obtained
	
	

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", address=" + address + ", country=" + country + ", state="
				+ state + ", email=" + email + ", phone=" + phone + "]";
	}

	//used for bidrectional maping
	public void addBook(Book book) {
		
		books.add(book);
		book.setTheAuthor(this);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
		book.setTheAuthor(null);
	}
}
