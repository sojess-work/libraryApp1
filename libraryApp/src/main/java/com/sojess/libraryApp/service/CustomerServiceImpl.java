package com.sojess.libraryApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sojess.libraryApp.DAO.Customer.CustomerDAO;
import com.sojess.libraryApp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO=customerDAO;
	}
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}
	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		
		return customerDAO.getCustomerById(id);
	}
	@Override
	@Transactional
	public int saveOrUpdateCustomer(Customer Customer) {
		return customerDAO.saveOrUpdateCustomer(Customer);
	}
	@Override
	@Transactional
	public void deleteCustomerById(int id) {
		customerDAO.deleteCustomerById(id);
	}
	

}
