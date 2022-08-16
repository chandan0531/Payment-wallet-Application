package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.entities.Transaction;
import com.masai.entities.TransactionType;
import com.masai.entities.Wallet;
import com.masai.exception.TransactionNotFoundException;

public interface TransactionService {

	
	
	public Transaction addTansaction(Transaction trans);
	
	public List<Transaction> viewAllTransactions(String key,Integer walletId) throws TransactionNotFoundException;
	
	public List<Transaction> viewTransactionByDate(Integer walletId, String date)throws TransactionNotFoundException;
	
	public List<Transaction> viewAllTransactions()throws TransactionNotFoundException;
}
