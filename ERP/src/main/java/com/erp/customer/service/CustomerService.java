package com.erp.customer.service;

import java.util.List;

import com.erp.customer.entity.Customer;

public interface CustomerService {

	// Save customer
	Customer saveCustomerData(Customer customer);
	
	// Get details of all customer
	List<Customer> getAllCustomer();
	
	
	// Get details of customer by ID
	Customer getCustomerById(long id);
	
}
