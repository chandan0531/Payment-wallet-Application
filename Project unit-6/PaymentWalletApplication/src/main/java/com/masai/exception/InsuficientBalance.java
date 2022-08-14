package com.masai.exception;

public class InsuficientBalance extends RuntimeException {

public InsuficientBalance() {
		
	}
	
	public InsuficientBalance(String message) {
		super(message);
	}
}
