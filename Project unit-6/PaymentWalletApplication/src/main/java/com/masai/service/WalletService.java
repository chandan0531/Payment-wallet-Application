package com.masai.service;

import java.math.BigDecimal;
import java.util.List;

import com.masai.entities.Customer;
import com.masai.entities.Wallet;

public interface WalletService {
	
	public Customer createAccount(String name, String mobileno, BigDecimal amount);
	
	public Customer showBalance(String mobileno);
	
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount);
	
	public Customer depositAmount(String mobileno, BigDecimal amount);
	
	public List<Customer> getList();
	
	public Customer updateAccount(Customer customer);
	
	public Customer addMoney(Wallet wallet,double amount);

}
