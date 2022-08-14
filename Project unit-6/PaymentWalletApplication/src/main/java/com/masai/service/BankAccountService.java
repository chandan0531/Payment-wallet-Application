package com.masai.service;


import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.masai.entities.BankAccount;
import com.masai.exception.BankAccountNotFound;


public interface BankAccountService {

	
	public String addAccount(BankAccount bankAccount);
	
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws AccountNotFoundException;

	public String removeAccount(Integer accountNumber)throws BankAccountNotFound;
	
	public List<BankAccount> viewAllBankAccountByWalletId(Integer walletId) throws BankAccountNotFound;
	
	
	
	
}
