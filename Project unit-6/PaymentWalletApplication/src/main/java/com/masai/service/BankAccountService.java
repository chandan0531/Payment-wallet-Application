package com.masai.service;


import javax.security.auth.login.AccountNotFoundException;

import com.masai.entities.BankAccount;


public interface BankAccountService {

	
	public String addAccount(BankAccount bankAccount);
	
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws AccountNotFoundException;

	
	
	
	//	public Wallet removeAccount(BankAccount bankAccount)throws BankAccountNotFound;
	
//	public BankAccount viewAccount(Wallet wallet) throws BankAccountNotFound;
	
//	public List<BankAccount> viewAllAccount(Wallet wallet) throws BankAccountNotFound;
	
	
	
}
