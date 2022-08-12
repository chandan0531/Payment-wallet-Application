package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.entities.Transaction;
import com.masai.entities.Wallet;

public interface TransactionService {

	
	
	public Transaction addTansaction(Transaction trans);
	
	public List<Transaction> viewAllTransactions(Wallet wallet);
	
	public List<Transaction> viewTransactionByDate(LocalDate from , LocalDate to);
	
	public List<Transaction> viewAllTransactions(String transactionType);
}
