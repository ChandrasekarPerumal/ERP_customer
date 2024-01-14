package com.erp.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import com.erp.customer.exception.CustomerIdNotFoundException;
import com.erp.customer.exception.PhoneNumberNotValidException;
import com.erp.customer.exception.UniqueConstraintViolationException;
import com.erp.customer.service.CustomerServiceImpl;

@RestController
@RequestMapping("erp/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;

	// Get customer data by using customer-id
	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable long customerId) {
		try {
			Customer customer = customerService.getCustomerById(customerId);
			if (customer != null) {
				return new ResponseEntity<>(customer, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(" Customer not found with ID:" + customerId, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Server-side error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Get all the customer
	@GetMapping()
	public List<?> getAll() {
		return customerService.getAllCustomer();
	}

	// Store new customer data
	@PostMapping("/new")
	public ResponseEntity<String> saveCustomerData(@RequestBody Customer customer) {
		try {
			if (customer.getPhoneNumber().length() != 10) {
				throw new PhoneNumberNotValidException("");
			}
			customerService.saveCustomerData(customer);
			return new ResponseEntity<>("Customer detail saved successfully", HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			throw new UniqueConstraintViolationException("Email address must be unique");
		} catch (PhoneNumberNotValidException e) {
			throw new UniqueConstraintViolationException("Phone Number is not valid");
		} catch (Exception e) {
			return new ResponseEntity<>("Server-side error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/* Save more than one customer data */
	@PostMapping("/bulk-load")
	public ResponseEntity<String> saveCustomerList(@RequestBody List<Customer> customerList) {
		try {
			customerList.forEach((customer) -> {
				if (  customer.getPhoneNumber().length() != 10) {
					throw new PhoneNumberNotValidException("");
				}
				customerService.saveCustomerData(customer);
			});
			return new ResponseEntity<>("Customer detail saved successfully", HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			throw new UniqueConstraintViolationException("Email address must be unique");
		} catch (PhoneNumberNotValidException e) {
			throw new UniqueConstraintViolationException("Phone Number is not valid");
		} catch (Exception e) {
			return new ResponseEntity<>("Server-side error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Update the customer data using customer-id
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCustomerById(@PathVariable int id, @RequestBody Customer customer) {
		try {
			customer.setId(id);
			customerService.updateCusotmerById(id, customer);
			return new ResponseEntity<>(" Customer details updated successfully ", HttpStatus.OK);
		} catch (PhoneNumberNotValidException e) {
			throw new UniqueConstraintViolationException("Phone Number is not valid");
		} catch (CustomerIdNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to update customer detail", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	/* Update more than one customer data */
	@PutMapping("/bulk-change")
	public ResponseEntity<String> updateCustomerById(@RequestBody List<Customer> customerList) {
		try {
			customerList.forEach((customer) -> {
				customerService.updateCusotmerById(customer.getId(), customer);
			});
			return new ResponseEntity<>(" Customer details updated successfully ", HttpStatus.OK);
		} catch (PhoneNumberNotValidException e) {
			throw new UniqueConstraintViolationException("Phone Number is not valid");
		} catch (CustomerIdNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to update customer detail", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Delete the customer data using customer-id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable int id) {
		try {
			customerService.deleteCustomerById(id);
			return new ResponseEntity<>("Deleted Customer with ID :" + id, HttpStatus.OK);
		} catch (CustomerIdNotFoundException e) {
//			throw new CustomerIdNotFoundException("Customer not found with the given ID");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Server-side error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
