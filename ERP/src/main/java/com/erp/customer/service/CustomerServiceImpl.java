package com.erp.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.customer.dao.CustomerDAO;
import com.erp.customer.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	public Customer saveCustomerData(Customer customer) {
		return customerDAO.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return customerDAO.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
		
		return null;
	}

}
