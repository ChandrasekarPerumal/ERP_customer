package com.erp.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.customer.entity.Customer;
import com.erp.customer.service.CustomerServiceImpl;


@RestController
@RequestMapping("erp/api/v1/customers")
public class CustomerController {

	
	@Autowired
	private CustomerServiceImpl customerService;
		
//	public CustomerController(CustomerService customerService){	
//		this.customerService = customerService;		
//	}
		

	// Get customer data by using customer-id
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById() {
		return null;
	}

	// Get all the customer
	@GetMapping("/")
	public List<?> getAll() {
		return null;
	}


	// Store new customer data
	@PostMapping("/new")
	public ResponseEntity<String> saveCustomerData(@RequestBody Customer customer) {
		try {
		customerService.saveCustomerData(customer);
		return new ResponseEntity<>("Customer detail saved successfully",HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// Update the customer data using customer-id
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCustomerById() {
		return null;
	}

	// Delete the customer data using customer-id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable int id) {
		return null;
	}

}
