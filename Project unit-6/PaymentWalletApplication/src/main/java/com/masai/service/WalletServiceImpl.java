package com.masai.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BankAccount;
import com.masai.entities.Customer;
import com.masai.entities.Wallet;
import com.masai.exception.BankAccountNotFound;
import com.masai.exception.InsuficientBalance;
import com.masai.exception.InvalidAccountException;
import com.masai.repository.BankAccountDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.TransactionDao;
import com.masai.repository.WalletDao;
import com.masai.userSessions.UserSessionsImpl;

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
	
	@Autowired
	private UserSessionsImpl userSessionsImpl;
	
	
	@Override
	public double showBalance(String mobileNumber) {
		
		Optional<Customer> otp = customerDao.findByMobileNumber(mobileNumber);
		
		if(otp.isPresent()) {
			return otp.get().getWallet().getBalance();
		}else {
			throw new InvalidAccountException("Invalid Account");
		}
		
		
	}


	
	

	@Override
	public Customer createAccount(Customer customer) {

		Wallet wallet = customer.getWallet();
		
		walletDao.save(wallet);
		
		return customerDao.save(customer);
	}





	@Override
	public String addMoney(double amount, String key,Integer Accno) {
		Wallet wallet = userSessionsImpl.getCustomerWallet(key);
		
		List<BankAccount> bankAccountList = wallet.getBankAccount();
		//System.out.println(bankAccountList);
		int count = 0;
		for(BankAccount ListofBank:bankAccountList) {
			System.out.println(ListofBank);
			if(ListofBank.getAccountNo().equals(Accno)) {
				if(ListofBank.getBalance()>=amount) {
					count++;
					ListofBank.setBalance(ListofBank.getBalance()-amount);
					wallet.setBalance(ListofBank.getBalance()+amount);
					
				}else {
					throw new InsuficientBalance("Balance is not Sufficient in Bank");
				}
			}
			
		}
		if(count==0) {
			throw new BankAccountNotFound("Account does not exist");
		}
		
		return amount+" Rupee is Credited into Wallet";
	}





	@Override
	public Customer addMoney(Wallet wallet, double amount) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public List<BankAccount> bankAccountByWalletId(Integer walletId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

	
}
