package com.masai.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Customer;
import com.masai.entities.Wallet;
import com.masai.exception.InvalidAccountException;
import com.masai.repository.BankAccountDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.TransactionDao;
import com.masai.repository.WalletDao;

@Service
public class WalletServiceImpl implements WalletService{

	@Autowired
	private BankAccountDao bankDao;
	
	@Autowired
	private WalletDao walletDao;
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	public BigDecimal showBalance(String mobileNumber) {
		
		Optional<Customer> otp = customerDao.findByMobileNumber(mobileNumber);
		
		if(otp.isPresent()) {
			return otp.get().getWallet().getBalance();
		}else {
			throw new InvalidAccountException("Invalid Account");
		}
		
		
	}


	@Override
	public Customer addMoney(Wallet wallet, double amount) {
		
		
		return null;
	}


	@Override
	public Customer createAccount(Customer customer) {

		Wallet wallet = customer.getWallet();
		
		walletDao.save(wallet);
		
		return customerDao.save(customer);
	}

	
	
	
	

	
}
