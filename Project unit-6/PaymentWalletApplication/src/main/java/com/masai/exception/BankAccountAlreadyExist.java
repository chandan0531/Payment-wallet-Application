package com.masai.exception;

public class BankAccountAlreadyExist extends RuntimeException{

	public BankAccountAlreadyExist() {
		
	}
	
	public BankAccountAlreadyExist(String message) {
		super(message);
	}
	
}
