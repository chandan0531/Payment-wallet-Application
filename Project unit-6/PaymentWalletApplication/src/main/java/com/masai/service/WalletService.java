package com.masai.service;

import java.math.BigDecimal;
import java.util.List;

import com.masai.entities.BankAccount;
import com.masai.entities.Customer;
import com.masai.entities.Wallet;
import com.masai.exception.InvalidAccountException;

public interface WalletService {
	
	
	
	public double showBalance(String key) throws InvalidAccountException;
	
	public String fundTransfer(String sourceMobileNo, String targetMobileNo, double amount,String key);
	
	public String depositAmount(double amount, String key, Integer Accno);
	
	public String addMoney(double amount, String key,Integer Accno);
	
	public List<BankAccount> bankAccountByWalletId(Integer walletId);
	
	public Customer getCustomerbyWalletId(Integer wlletId);
}
