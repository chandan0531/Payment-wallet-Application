package com.masai.service;


import javax.security.auth.login.AccountNotFoundException;

import com.masai.entities.BankAccount;
import com.masai.exception.BankAccountNotFound;


public interface BankAccountService {

	
	public String addAccount(BankAccount bankAccount);
	
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws AccountNotFoundException;

	public String removeAccount(Integer accountNumber)throws BankAccountNotFound;
	
	
	public BankAccount viewAccount(Integer walletId) throws BankAccountNotFound;
	
//	public List<BankAccount> viewAllAccount(Wallet wallet) throws BankAccountNotFound;
	
	
	
}
