package com.sojess.libraryApp.service;

import java.util.List;

import com.sojess.libraryApp.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomerById(int id);
	
	public int saveOrUpdateCustomer(Customer Customer);
	
	public void deleteCustomerById(int id);

}
