package com.masai.exception;

public class InvalidDetailsException extends RuntimeException{

	public InvalidDetailsException() {
		
	}
	
	public InvalidDetailsException(String message) {
		super(message);
	}
	
}
