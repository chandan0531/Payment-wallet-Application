package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.BankAccount;
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
	
	
	@GetMapping("/transactions")
	ResponseEntity<List<Transaction>> viewAllTransactionsHandler(){
		
		List<Transaction> Transactions =   transService.viewAllTransactions();
		return new ResponseEntity<List<Transaction>>(Transactions,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/transactions/{walletId}/{date}")
	ResponseEntity<List<Transaction>> viewTransactionByDateHandler(@PathVariable Integer walletId,
														@PathVariable String date
					){
		
		List<Transaction> Transactions = transService.viewTransactionByDate(walletId, date);
		return new ResponseEntity<List<Transaction>>(Transactions,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/transactions/{key}/{walletId}")
	ResponseEntity<List<Transaction>> viewAllTransactionsWalletHandler(@PathVariable String key,
														@PathVariable Integer walletId
					){
		
		List<Transaction> Transactions =  transService.viewAllTransactions(key, walletId);
		
		return new ResponseEntity<List<Transaction>>(Transactions,HttpStatus.OK);
	}
	
}
