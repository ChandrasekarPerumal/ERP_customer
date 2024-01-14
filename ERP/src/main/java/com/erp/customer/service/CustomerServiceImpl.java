package com.erp.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.customer.dao.CustomerDAO;
import com.erp.customer.entity.Customer;
import com.erp.customer.exception.CustomerIdNotFoundException;

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
		return customerDAO.findById(id).get();
	}

	@Override
	public void deleteCustomerById(long id) {
		if (!customerDAO.existsById(id)) {
			throw new CustomerIdNotFoundException("Customer not found with ID: "+id);
		}
		customerDAO.deleteById(id);
	}

	@Override
	public Customer updateCusotmerById(long id, Customer cusomer) {
		// TODO Auto-generated method stub
		return null;
	}

}
