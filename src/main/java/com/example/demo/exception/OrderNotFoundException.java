package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9079454849611061074L;

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(final String message) {
		super(message);
	}

}