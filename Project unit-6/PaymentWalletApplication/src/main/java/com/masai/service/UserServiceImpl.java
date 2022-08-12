package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BankAccount;
import com.masai.exception.BankAccountNotFound;
import com.masai.repository.CustomerDao;
import com.masai.repository.UserServiceDao;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserServiceDao userService;
	
	@Autowired
	CustomerDao customer;
	
	@Override
	public String validateLogin(String mobileNumber, String password) {
	
		
	String  account =	userService.findByMobileNumberAndPassword();
		
	if(account == null) {
		throw new BankAccountNotFound("Bank account not found");
	}
	
		return "Login Successfull";
		
	}

	
}
