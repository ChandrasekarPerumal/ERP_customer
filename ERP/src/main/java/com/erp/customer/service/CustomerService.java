package com.erp.customer.service;

import java.util.List;
import java.util.Optional;

import com.erp.customer.entity.Customer;

public interface CustomerService {

	// Save customer
	Customer saveCustomerData(Customer customer);
	
	// Get details of all customer
	List<Customer> getAllCustomer();
	
	
	// Get details of customer by ID
	Customer getCustomerById(long id);
	
	// Delete Customer by ID
	void deleteCustomerById(long id);
	
	// Update Customer by ID
	Customer updateCusotmerById(long id,Customer customer);
	
}
