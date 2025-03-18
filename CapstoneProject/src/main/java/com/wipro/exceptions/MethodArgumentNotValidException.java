package com.wipro.exceptions;


public class MethodArgumentNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MethodArgumentNotValidException() {

	}

	public MethodArgumentNotValidException(String message) {
		super(message);
	}
}

