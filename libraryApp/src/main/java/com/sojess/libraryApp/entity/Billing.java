package com.sojess.libraryApp.entity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="billing")
public class Billing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="billing_id")
	private int id;
	
	@Column(name="booking_cost")
	private int bookingCost;
	
	@Column(name="billing_address")
	private String address;
	
	@Column(name="card_number")
	private String cardNo;
	
	@Column(name="billing_zipcode")
	private String zipCode;
	
	@Column(name="billing_state")
	private String billingState;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH,CascadeType.DETACH},fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	@JsonBackReference(value="customer-billing")
	private Customer theCustomerBill;
	
	public Billing() {
		
	}

	public Billing(int bookingCost, String address, String cardNo, String zipCode, String billingState) {
	
		this.bookingCost = bookingCost;
		this.address = address;
		this.cardNo = cardNo;
		this.zipCode = zipCode;
		this.billingState = billingState;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookingCost() {
		return bookingCost;
	}

	public void setBookingCost(int bookingCost) {
		this.bookingCost = bookingCost;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}


	public Customer getTheCustomerBill() {
		return theCustomerBill;
	}

	public void setTheCustomerBill(Customer theCustomerBill) {
		this.theCustomerBill = theCustomerBill;
	}

	@Override
	public String toString() {
		return "Billing [id=" + id + ", bookingCost=" + bookingCost + ", address=" + address + ", cardNo=" + cardNo
				+ ", zipCode=" + zipCode + ", billingState=" + billingState + "]";
	}
	
	
	

}
