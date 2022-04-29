package com.sojess.libraryApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="customer")
public class Customer {

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
	
	@OneToMany(mappedBy = "theCustomer",cascade= {CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH,CascadeType.DETACH})
	@JsonManagedReference(value="customer-booking")
	private List<Booking> bookings =new ArrayList<>();
	
	@OneToMany(mappedBy = "theCustomerBill",cascade= {CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH,CascadeType.DETACH})
	@JsonManagedReference(value="customer-billing")
	private List<Billing> billings =new ArrayList<>();
	
	public Customer() {
		
	}

	public Customer(String name, String address, String country, String state, String email, String phone) {
		
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
	
	
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	public void addBooking(Booking booking) {
		bookings.add(booking);
		booking.setTheCustomer(this);
	}
	
	public void removeBooking(Booking booking) {
		bookings.remove(booking);
		booking.setTheCustomer(null);
	}
	
	public void addBilling(Billing billing) {
		billings.add(billing);
		billing.setTheCustomerBill(this);
	}
	
	public void removeBilling(Billing billing) {
		bookings.remove(billing);
		billing.setTheCustomerBill(null);
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", country=" + country + ", state="
				+ state + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
