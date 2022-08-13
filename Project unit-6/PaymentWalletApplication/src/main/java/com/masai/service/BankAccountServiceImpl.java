package com.masai.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BankAccount;
import com.masai.repository.BankAccountDao;


@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountDao bankAccDao;
	
	
	@Override
	public String addAccount(BankAccount bankAccount) {

		
		
	    BankAccount bank =	bankAccDao.findByBankNameAndWallet(bankAccount.getBankName(), bankAccount.getWallet().getWalletId());
		
		if(bank!=null) {
			return "Account exists";
		}
	   
		BankAccount acc = new BankAccount();
		
		acc.setBankName(bankAccount.getBankName());
		acc.setIfscCode(bankAccount.getIfscCode());
		acc.setBalance(bankAccount.getBalance());
		
		acc.setWallet(bankAccount.getWallet());
	
		bankAccDao.save(acc);
		
		return "added..";
	}

	
	
}
