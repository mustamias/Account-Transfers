package com.ac.entities.exception;

public class InsufficientAccountBalanceException extends Exception {
	
	
	private static final long serialVersionUID = -7758312841664430392L;

	public InsufficientAccountBalanceException(String message) {
		super(message);
	}

}
