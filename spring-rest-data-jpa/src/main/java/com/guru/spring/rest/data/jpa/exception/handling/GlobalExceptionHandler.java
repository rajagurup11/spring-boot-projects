package com.guru.spring.rest.data.jpa.exception.handling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(EmployeeNotFoundException ex) {
		ErrorResponse errRes = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, "Employee Not Found",
				ex.getMessage());
		return ResponseEntityBuilder.build(errRes);
	}
}