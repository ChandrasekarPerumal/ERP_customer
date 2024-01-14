package com.erp.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	
	/* Exception for Unique value constraint */
	@ExceptionHandler(UniqueConstraintViolationException.class)
    public ResponseEntity<String> handleUniqueConstraintViolationException(
            UniqueConstraintViolationException constraintViolationException) {
        String errorMessage = "Email Id is not unique";
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT); 
    }
	
	/* Customer ID is not found  */
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<String> handleIdNotFoundException(
            CustomerIdNotFoundException idNotFoundException) {
        String errorMessage = "Customer not found with the given ID ";
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
	
	//
	@ExceptionHandler(PhoneNumberNotValidException.class)
	public ResponseEntity<String> handlePhoneNumberException(PhoneNumberNotValidException notValidException){
		String errorMessage = "Invalid phone number ";
		
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
		
	}
	
}
