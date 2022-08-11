package com.masai.exception;

public class BankAccountNotFound extends RuntimeException{

	public BankAccountNotFound() {
		
	}
	
	public BankAccountNotFound(String message) {
		super(message);
	}
	
}
