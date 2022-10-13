package com.masai.service;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BankAccount;
import com.masai.entities.UserSession;
import com.masai.entities.Wallet;
import com.masai.exception.BankAccountNotFound;
import com.masai.exception.WalletNotFound;
import com.masai.repository.BankAccountDao;
import com.masai.repository.UserSessionDao;
import com.masai.repository.WalletDao;


@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountDao bankAccDao;
	
	@Autowired
	WalletDao walletdao;
	
	@Autowired
	UserSessionDao sessionDao;
	
	@Override
	public String addAccount(BankAccount bankAccount,Integer walletId, String key) {


		   
		   Optional<UserSession> currentUser =  sessionDao.findByUuid(key);
		   
		   if(currentUser.isPresent()) {

				  Optional<Wallet> wallet =   walletdao.findByWalletId(walletId);
				   
				  if(wallet.isPresent()) {
					  wallet.get().getBankAccount().add(bankAccount);
			          bankAccount.setWallet(wallet.get());
					  
				walletdao.save(wallet.get());
					  
					  
				  }else {
					  return "wallet not found";
				  }
				  
				  
				return bankAccount.getBankName()+" is successfully added..";
		   }
		   
			return "user not found "+walletId;
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
	public String removeAccount(Integer accountNumber, String key) throws BankAccountNotFound {
	
	Optional<UserSession> user = sessionDao.findByUuid(key);
		
	if(user.isPresent()) {
		 Optional<BankAccount> account =    bankAccDao.findByAccountNo(accountNumber);
		    
		  if(!account.isPresent()) {
			  throw new BankAccountNotFound("bank account not found in our database");
			  
		  }
		  
		  bankAccDao.deleteById(accountNumber);
		  
		  return "Bank Account deleted  Successfully";
	}
	
	return "wrong key";	 
	}
	
	
	

	
	@Override
	public   List<BankAccount>  viewAllBankAccountByWalletId(Integer walletId) throws BankAccountNotFound {
	
		
	Wallet wallet =	 walletdao.getById(walletId);
		
    List<BankAccount> banks =  	wallet.getBankAccount();
    
    
    return banks;
	}
	
}
