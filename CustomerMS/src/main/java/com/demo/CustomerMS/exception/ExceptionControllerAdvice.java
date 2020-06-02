package com.demo.CustomerMS.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 
 * @author lappy
 *
 */

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(value = NoResourceFoundException.class)
	public ResponseEntity<ErrorMessage> handleGenericNotFoundException(NoResourceFoundException ex)
	{
		ErrorMessage error = new ErrorMessage("NOT_FOUND_ERROR",ex.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorMessage>(error,HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * 
	 * @param ex
	 * @return
	 */
	
	@ExceptionHandler(value = DuplicateResourceException.class)
	public ResponseEntity<ErrorMessage> handleGenericDuplicateException(DuplicateResourceException ex)
	{
		
		ErrorMessage error = new ErrorMessage("ALREADY EXISTS", ex.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.CONFLICT.value());
		return new ResponseEntity<ErrorMessage>(error,HttpStatus.CONFLICT);
		
	}

}
