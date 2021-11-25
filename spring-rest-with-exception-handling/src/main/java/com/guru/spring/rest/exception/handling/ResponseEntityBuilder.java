package com.guru.spring.rest.exception.handling;

import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
	public static ResponseEntity<Object> build(ErrorResponse apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}