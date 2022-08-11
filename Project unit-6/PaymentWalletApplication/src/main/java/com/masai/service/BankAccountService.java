package com.masai.service;

import java.util.List;

import com.masai.entities.BankAccount;
import com.masai.entities.Wallet;
import com.masai.exception.BankAccountNotFound;

public interface BankAccountService {

	
	public Wallet addAccount(BankAccount bankAccount);
	
	public Wallet removeAccount(BankAccount bankAccount)throws BankAccountNotFound;
	
	public BankAccount viewAccount(Wallet wallet) throws BankAccountNotFound;
	
	public List<BankAccount> viewAllAccount(Wallet wallet) throws BankAccountNotFound;
	
	
	
}
