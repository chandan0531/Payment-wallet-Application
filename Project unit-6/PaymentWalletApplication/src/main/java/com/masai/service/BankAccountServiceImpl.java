package com.masai.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BankAccount;
import com.masai.entities.Wallet;
import com.masai.repository.BankAccountDao;
import com.masai.repository.TransactionDao;
import com.masai.repository.WalletDao;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountDao bankAccDao;
	
	@Autowired
	TransactionDao transDao;
	
	@Autowired
	WalletDao walletDao;
	
	
	@Override
	public String addAccount(BankAccount bankAccount) {

		
		
	    BankAccount bank =	bankAccDao.findByBankNameAndWalletId(bankAccount.getBankName(), bankAccount.getWallet().getWalletId());
		
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

	@Override
	public Wallet removeAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount viewAccount(Wallet wallet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccount> viewAllAccount(Wallet wallet) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
