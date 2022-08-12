package com.masai.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.BankAccount;

@RestController
public class BankAccountController {

	
	@PostMapping("/banks")
	ResponseEntity<BankAccount> addAccount(@Valid @RequestBody BankAccount bankAccount){
		
		return new ResponseEntity<BankAccount>(bankAccount,HttpStatus.CREATED);
	}
}
