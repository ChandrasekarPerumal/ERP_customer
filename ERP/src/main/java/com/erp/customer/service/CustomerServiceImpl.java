package com.erp.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.customer.dao.CustomerDAO;
import com.erp.customer.entity.Customer;
import com.erp.customer.exception.CustomerIdNotFoundException;
import com.erp.customer.exception.PhoneNumberNotValidException;

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
			throw new CustomerIdNotFoundException();
		}
		customerDAO.deleteById(id);
	}

	@Override
	public Customer updateCusotmerById(long id, Customer customer) {
		if (!customerDAO.existsById(id)) {
			throw new CustomerIdNotFoundException();
		} else {

			// Get customers existing details
			Customer existCustomer = customerDAO.findById(id).get();

			// Check for update value
			if (customer.getName() != null) {
				existCustomer.setName(customer.getName());
			}
			if (customer.getEmailId() != null) {
				existCustomer.setEmailId(customer.getEmailId());
			}
			if (customer.getPhoneNumber() != null) {
				if (customer.getPhoneNumber().length() != 10) {
					throw new PhoneNumberNotValidException();
				}
				existCustomer.setName(customer.getPhoneNumber());
			}
			if (customer.getAddress() != null) {
				existCustomer.setName(customer.getAddress());
			}

			if (customer.getCompanyName() != null) {
				existCustomer.setName(customer.getCompanyName());
			}
			if (customer.getIndustryType() != null) {
				existCustomer.setName(customer.getIndustryType());
			}
			if (customer.getCustomerStatus() != null) {
				existCustomer.setName(customer.getCustomerStatus());
			}
			if (customer.getAccountManager() != null) {
				existCustomer.setName(customer.getAccountManager());
			}

			// Update the customer detail
			customerDAO.save(existCustomer);
		}

		return null;
	}

}
