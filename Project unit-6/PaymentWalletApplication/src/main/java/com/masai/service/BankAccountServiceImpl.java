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
				   
				  wallet.get().getBankAccount().add(bankAccount);
				
				  walletdao.save(wallet.get());
				  
				return " is successfully added..";
		   }
		   
			return "not found";
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
		
		System.out.println("inside fun");
		
		List<BankAccount> allbank = new ArrayList<>();
		
	Optional<Wallet> bankAccount = walletdao.findById(walletId);
	
	System.out.println(bankAccount+"dddddddddd");

	if(!bankAccount.isPresent()) {
	throw new BankAccountNotFound("bank account not found with this wallet Id");
	}
	
	
	
	List<BankAccount>  banks =  bankAccount.get().getBankAccount();	
	
   banks.forEach((s->{

	  s.getAccountNo();
	  s.getBankName();
	  
	  
	
  }));
  
   System.out.println(banks+"ccccccccccccccccccc");
   return banks;
	}	
	
	
}
