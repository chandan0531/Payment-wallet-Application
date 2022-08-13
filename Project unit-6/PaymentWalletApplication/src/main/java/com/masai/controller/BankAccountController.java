package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.BankAccount;
import com.masai.service.BankAccountServiceImpl;

@RestController
@Component
public class BankAccountController {

	@Autowired
	@Qualifier("BankAccSer")
	BankAccountServiceImpl bankService;
	
	@PostMapping("/banks")
	ResponseEntity<String> addAccount(@Valid @RequestBody BankAccount bankAccount){
		
	return new ResponseEntity<String>(bankService.addAccount(bankAccount),HttpStatus.CREATED);
	}
}
