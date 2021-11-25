package com.guru.spring.rest.exception.handling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private HttpStatus status;
	private String message;
	private String exceptionMessage;

	public ErrorResponse(LocalDateTime now, HttpStatus status, String message, String exceptionMessage) {
		this.timestamp = now;
		this.status = status;
		this.message = message;
		this.exceptionMessage = exceptionMessage;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrors() {
		return exceptionMessage;
	}

	public void setErrors(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}