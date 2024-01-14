package com.erp.customer.exception;

public class PhoneNumberNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PhoneNumberNotValidException(String message) {
		super(message);
	}
	
}
