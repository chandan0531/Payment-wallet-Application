package com.masai.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.entities.Customer;
import com.masai.entities.Wallet;

@Service
public class WalletServiceImpl implements WalletService{

	@Override
	public Customer createAccount(String name, String mobileno, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer showBalance(String mobileno) {
		// TODO Auto-generated method stub
		return null;
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
