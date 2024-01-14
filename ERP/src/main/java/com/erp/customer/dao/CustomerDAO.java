package com.erp.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.customer.entity.Customer;


// Database

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Long> {

}
