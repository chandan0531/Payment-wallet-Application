package com.masai.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Transaction;
import com.masai.entities.UserSession;
import com.masai.entities.Wallet;
import com.masai.exception.TransactionNotFoundException;
import com.masai.exception.UserNotFoundException;
import com.masai.exception.WalletNotFound;
import com.masai.repository.TransactionDao;
import com.masai.repository.UserSessionDao;
import com.masai.repository.WalletDao;


@Service
public class TransactionServiceImpl implements TransactionService{


	@Autowired
	private TransactionDao tDao;
	
	@Autowired
	private WalletDao wDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	@Override
	public Transaction addTansaction(Transaction trans) {
		Wallet wallet = trans.getWallet();
		
		Transaction transactions = tDao.save(trans);
		transactions.setWallet(wallet);
		
		
		return transactions;
	}

	@Override
	public List<Transaction> viewAllTransactions(String key,Integer walletId)throws TransactionNotFoundException,UserNotFoundException{

		
		Optional<UserSession> optionalUserSession = userSessionDao.findByUuid(key);
		
		if(!optionalUserSession.isPresent())
		{
			throw new UserNotFoundException("Unauthorized key");
		}
		else
		{
			Optional<Wallet> wallet= wDao.findById(walletId);
			if(!wallet.isPresent())
			{
				throw new WalletNotFound("Wallet not found");
			}
			List <Transaction>  transations = wallet.get().getTransactions();
			
			Transaction t = new Transaction();
			t.setWallet(wallet.get());
			
			if(transations.size() >0)
			{
				return transations;
			}
			else
			{
				throw new TransactionNotFoundException("Transaction not found");
			}
		}
		
	}

	@Override
	public List<Transaction> viewTransactionByDate(Integer walletId, String date)throws TransactionNotFoundException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate ld = LocalDate.parse(date, dtf);
		
		Optional<Wallet> wallet= wDao.findById(walletId);
		if(!wallet.isPresent())
		{
			throw new WalletNotFound("Wallet not found");
		}
		List <Transaction>  transations = wallet.get().getTransactions();
		
		List <Transaction>  transationsDWIthDate = new ArrayList<>();
		
		for(Transaction tc : transations )
		{
			if(tc.getTransactionDate().equals(ld))
			{
				transationsDWIthDate.add(tc);
			}
		}
		
		
		if(transationsDWIthDate.size()>0)
		{
			return transationsDWIthDate;
		}
		else
		{
			throw new TransactionNotFoundException("Transaction not found in given date");
		}
	}

	@Override
	public List<Transaction> viewAllTransactions() throws TransactionNotFoundException{
		
	
		List<Transaction> transactions =  tDao.findAll();
		if(transactions.size() >0)
		{
			return transactions;
		}
		else
		{
			throw new TransactionNotFoundException("Transaction not found");
		}
	
	}
}
