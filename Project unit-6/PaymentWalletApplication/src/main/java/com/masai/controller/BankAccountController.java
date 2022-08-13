package com.masai.controller;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.BankAccount;
import com.masai.repository.BankAccountDao;
import com.masai.service.BankAccountService;
import com.masai.service.BankAccountServiceImpl;

@RestController
public class BankAccountController {

	@Autowired
    private BankAccountService bankService;

	@Autowired
	BankAccountDao bankDao;
	

	
	@PostMapping("/banks")
    public String addAccount(@Valid @RequestBody BankAccount bankAccount){
		
		return bankService.addAccount(bankAccount);
	}
}
