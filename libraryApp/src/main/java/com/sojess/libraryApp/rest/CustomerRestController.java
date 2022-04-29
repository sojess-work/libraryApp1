package com.sojess.libraryApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sojess.libraryApp.entity.Customer;
import com.sojess.libraryApp.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerRestController(CustomerService customerService) {
		this.customerService= customerService;
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
	return customerService.getCustomers();
		
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		
		Customer customer=customerService.getCustomerById(customerId);
		return customer;
	}
	
	@PostMapping("/customers")
	public int saveCustomer(@RequestBody Customer customer) {
		
		customer.setId(0);
		return customerService.saveOrUpdateCustomer(customer);
	}
	
	@PutMapping("/customers")
	public int updateCustomer(@RequestBody Customer customer) {
		return customerService.saveOrUpdateCustomer(customer);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String  deleteCustomer(@PathVariable int customerId) {
		
		Customer customer = customerService.getCustomerById(customerId);
		if(customer==null) {
			throw new RuntimeException("There is no user with id: "+customerId);
			
		}
		customerService.deleteCustomerById(customerId);
		return "Customer with id "+customerId+" deleted!";
	}
}
