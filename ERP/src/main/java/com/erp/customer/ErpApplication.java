package com.erp.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ErpApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ErpApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
