package com.masai.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Customer;
import com.masai.entities.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.repository.TransactionDao;

@Service
public class WalletServiceImpl implements WalletService{

	@Autowired
	private BankAccountDao bankDao;
	
	@Autowired
	private TransactionDao transactionDao;
	
	
	
	@Override
	public Customer createAccount(String name, String mobileno, BigDecimal amount) {
		
		
		return null;
	}

	@Override
	public double showBalance(String mobileno) {

		
		return 2;
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer depositAmount(String mobileno, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateAccount(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addMoney(Wallet wallet, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
