package com.sojess.libraryApp.DAO.Customer;

import java.util.List;

import com.sojess.libraryApp.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomerById(int id);
	

	
	public int saveOrUpdateCustomer(Customer Customer);
	
	public void deleteCustomerById(int id);
	

}
