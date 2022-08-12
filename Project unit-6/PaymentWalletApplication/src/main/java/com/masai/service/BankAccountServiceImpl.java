package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.entities.BankAccount;
import com.masai.entities.Wallet;
import com.masai.exception.BankAccountAlreadyExist;
import com.masai.repository.BankAccountDao;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	@JsonIgnore
	BankAccountDao bankAccDao;
	
	@Override
	public Wallet addAccount(BankAccount bankAccount) {
		
    BankAccount bank =	bankAccDao.findByBankNameAndWalletId(bankAccount.getBankName(), bankAccount.getAccountNo());
	
	if(bank!=null) {
		throw new BankAccountAlreadyExist("Bank Account with this details already exist");
	}
    
	BankAccount acc = new BankAccount();
	
	acc.setBankName(bankAccount.getBankName());
	acc.setIfscCode(bankAccount.getIfscCode());
	acc.setBalance(bankAccount.getBalance());
	
	acc.setWallet(bankAccount.getWallet());
	
	bankAccDao.save(acc);
	
	return bankAccount.getWallet();
	
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
