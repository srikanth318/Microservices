package com.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(ProductServiceException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceException ex){
		
		ErrorResponse error = ErrorResponse.builder()
				.message(ex.getMessage())
				.errorCode(ex.getErrorcode())
				.build();
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
