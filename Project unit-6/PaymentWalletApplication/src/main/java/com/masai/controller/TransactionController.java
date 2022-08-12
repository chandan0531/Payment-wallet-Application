package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Transaction;
import com.masai.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transService;
	
	@PostMapping("/transaction")
	public Transaction saveTransactionHandler(@RequestBody Transaction trans){
		
		
		Transaction transaction =  transService.addTansaction(trans);
		return transaction;
	}
}
