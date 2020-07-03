package com.example.demo.exception;

public class InvalidUser extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2961949543785450910L;

	public InvalidUser() {
		super();
	}

	public InvalidUser(String message) {
		super(message);
	}

}
