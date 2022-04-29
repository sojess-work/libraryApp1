package com.sojess.libraryApp.DAO.Customer;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sojess.libraryApp.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
//Querrying list of customers from customer table
	@Override 
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//get the customers list
		Query<Customer> q =  session.createQuery("from Customer",Customer.class);
		List<Customer> customers = q.getResultList();
		
		//return the customers list
		return customers;
	}
	//Querrying  customer by id from customer table in database
	@Override
	public Customer getCustomerById(int id) {
		//get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//get the customer by id
		Customer customer = session.get(Customer.class, id);
//		Customer customer = new Customer("Leslie","4-8-814, Opp Ram Mandir, Gowliguda","India","Andhra Pradesh","lesli@gmail.com","+911234567890");
//		customer.setId(id);//return the customer
		return customer;
	}
//saving or updating a customer to the table in database
	@Override
	public int saveOrUpdateCustomer(Customer customer) {
		//get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//saving/updating the Customer
		session.saveOrUpdate(customer);
		
		//returning customer id for verification
		
		return (int)session.getIdentifier(customer);
	}

	@Override
	public void deleteCustomerById(int id) {
		//get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//creating a query for deleting the customer by id
		Query q = session.createQuery("delete from Customer where id=:customerId");
		q.setParameter("customerId", id);
		q.executeUpdate();
	}

	

}
