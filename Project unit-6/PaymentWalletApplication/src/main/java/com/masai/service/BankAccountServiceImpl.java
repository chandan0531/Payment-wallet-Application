package com.masai.service;



import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BankAccount;
import com.masai.entities.Wallet;
import com.masai.exception.BankAccountNotFound;
import com.masai.exception.WalletNotFound;
import com.masai.repository.BankAccountDao;
import com.masai.repository.WalletDao;


@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountDao bankAccDao;
	
	@Autowired
	WalletDao walletdao;
	
	
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


	@Override
	public String removeAccount(Integer accountNumber) throws BankAccountNotFound {
	
		
		  Optional<BankAccount> account =    bankAccDao.findByAccountNo(accountNumber);
    
		  if(!account.isPresent()) {
			  throw new BankAccountNotFound("bank account not found in our database");
			  
		  }
		  
		  bankAccDao.deleteById(accountNumber);
		  
		  return "Bank Account deleted  Successfully";
	}


	@Override
	public BankAccount viewAccount(Integer walletId) throws BankAccountNotFound {
		// TODO Auto-generated method stub
		return null;
	}

/*
	@Override
	public BankAccount viewAccount(Integer walletId) throws BankAccountNotFound {
		
	Optional<Wallet> bankAccount = walletdao.findById(walletId);
	
	if(bankAccount == null) {
		throw new WalletNotFound("wallet not found with this wallet Id");
	}
	
	if(!bankAccount.isPresent()) {
	throw new BankAccountNotFound("bank account not found with this wallet Id");
	}
	
	 bankAccount.get()
	
	
	
	}
	*/
	
	
	
	
	
}
