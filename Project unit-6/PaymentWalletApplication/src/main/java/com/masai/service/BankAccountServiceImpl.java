package com.masai.service;



import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BankAccount;
import com.masai.exception.BankAccountNotFound;
import com.masai.repository.BankAccountDao;


@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountDao bankAccDao;
	
	
	@Override
	public String addAccount(BankAccount bankAccount) {


		   BankAccount newBank = bankAccDao.findByBankNameAndWallet(bankAccount.getBankName(),bankAccount.getWallet().getWalletId());
		   if(newBank!=null)
			   return "Account Already Exists";
      
	
		   
			BankAccount newAccount = new BankAccount();
		
			newAccount.setIfscCode(bankAccount.getIfscCode());
			newAccount.setBalance(bankAccount.getBalance());
			newAccount.setBankName(bankAccount.getBankName());
			
			newAccount.setWallet(bankAccount.getWallet());
			
			
			bankAccDao.save(newAccount);
			
			return newAccount.getBankName()+" is successfully added..";
}


	@Override
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws AccountNotFoundException {
	
		Optional<BankAccount> opt = bankAccDao.findById(accountNumber);
	    
		if(opt.isPresent()) {
			return opt.get();
		}
		
	    throw new BankAccountNotFound("Bank Account With not Found with given account number "+accountNumber);
	}
	
	
	
	
	
	
}
