package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Transaction;
import com.masai.entities.Wallet;
import com.masai.repository.TransactionDao;


@Service
public class TransactionServiceImpl implements TransactionService{


	@Autowired
	private TransactionDao tDao;
	
	
	@Override
	public Transaction addTansaction(Transaction trans) {
		Wallet wallet = trans.getWallet();
		
		Transaction transactions = tDao.save(trans);
		transactions.setWallet(wallet);
		
		return transactions;
	}

	@Override
	public List<Transaction> viewAllTransactions(Wallet wallet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> viewTransactionByDate(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> viewAllTransactions(String transactionType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
