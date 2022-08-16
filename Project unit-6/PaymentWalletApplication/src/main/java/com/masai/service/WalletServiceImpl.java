package com.masai.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BankAccount;
import com.masai.entities.Customer;
import com.masai.entities.Transaction;
import com.masai.entities.TransactionType;
import com.masai.entities.Wallet;
import com.masai.exception.BankAccountNotFound;
import com.masai.exception.InsuficientBalance;
import com.masai.exception.InvalidAccountException;
import com.masai.exception.WalletNotFound;
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
	public String fundTransfer(String sourceMobileNo, String targetMobileNo, double amount,String key) {

		Wallet sourceWallet = userSessionsImpl.getCustomerWallet(key);
		Customer sourceCustomer = userSessionsImpl.getCustomer(key);
		
		if(sourceWallet.getBalance()<amount) {
			throw new InsuficientBalance("Balance is not Sufficient in Source Wallet");
		}
		
		Optional<Customer> OptionalTargetCustomer = customerDao.findByMobileNumber(targetMobileNo);
		
		if(!OptionalTargetCustomer.isPresent()) {
			throw new BankAccountNotFound("Account does not exist with this mobile Number");
		}
		
		Customer TargetCustomer = OptionalTargetCustomer.get();
		Wallet TargetWallet = TargetCustomer.getWallet();
		sourceWallet.setBalance(sourceWallet.getBalance()-amount);
		TargetWallet.setBalance(TargetWallet.getBalance()+amount);
		
		Transaction sourceTransaction = new Transaction();
		sourceTransaction.setTransactionType("WALLETTOWALLETFOUNDTRANSFER");
		sourceTransaction.setTransactionDate(LocalDate.now());
		sourceTransaction.setAmount(amount);
		sourceTransaction.setDescription("Fund Transfer from " +sourceMobileNo+ " To "+ targetMobileNo);
		
		Transaction targetTransaction = new Transaction();
		targetTransaction.setTransactionType("WALLETTOWALLETFOUNDTRANSFER");
		targetTransaction.setTransactionDate(LocalDate.now());
		targetTransaction.setAmount(amount);
		targetTransaction.setDescription("Fund Transfer from " +sourceMobileNo+ " To "+ targetMobileNo);
		
		sourceWallet.getTransactions().add(sourceTransaction);
		TargetWallet.getTransactions().add(targetTransaction);
		
		transactionDao.save(sourceTransaction);
		transactionDao.save(targetTransaction);
		
		
		walletDao.save(sourceWallet);
		walletDao.save(TargetWallet);
		
		
		
		return "Fund is Transferred from "+sourceCustomer.getName()+ " To "+ TargetCustomer.getName();
	}
	
	@Override
	public double showBalance(String key) {
		
		double balance = userSessionsImpl.getCustomerWallet(key).getBalance();
		
		
			return balance;
		
	}


	@Override
	public String addMoney(double amount, String key,Integer Accno) {
    Wallet wallet = userSessionsImpl.getCustomerWallet(key);
		
    BankAccount ListofBank =   bankDao.getById(Accno);
    
		
    
		int count = 0;
			if(ListofBank.getAccountNo().equals(Accno)) {
				if(ListofBank.getBalance()>=amount) {
					count++;
					ListofBank.setBalance(ListofBank.getBalance()-amount);
					wallet.setBalance(wallet.getBalance()+amount);
					
					
					bankDao.save(ListofBank);
					walletDao.save(wallet);
					
					Transaction transaction = new Transaction();
					transaction.setTransactionType("BankToWallet");
					transaction.setTransactionDate(LocalDate.now());
					transaction.setAmount(amount);
					transaction.setDescription("Fund Transfer from Bank to Wallet" );
					
					wallet.getTransactions().add(transaction);
					
					transactionDao.save(transaction);
					
				}else {
					throw new InsuficientBalance("Balance is not Sufficient in Bank");
				}
			}
		
		if(count==0) {
			throw new BankAccountNotFound("Account does not exist");
		}
		
		return amount+" Rupee is Credited into Wallet";
	}



	@Override
	public List<BankAccount> bankAccountByWalletId(Integer walletId) {
		//Wallet wallet = userSessionsImpl.getCustomerWallet(key);
		
		Optional<Wallet> opt =  walletDao.findByWalletId(walletId);

		if(opt==null) {
			throw new WalletNotFound("wallet not found with given wallet id "+walletId);
		}
		
		if(!opt.isPresent()) {
		
		throw new BankAccountNotFound("bank account not found with given wallet id "+walletId);
		
		}
		
		return opt.get().getBankAccount();
		
	}


	@Override
	public String depositAmount(double amount, String key, Integer Accno) {
		Wallet wallet = userSessionsImpl.getCustomerWallet(key);
		
	    BankAccount ListofBank =   bankDao.getById(Accno);

			int count = 0;
			
				if(ListofBank.getAccountNo().equals(Accno)) {
					if(wallet.getBalance()>=amount) {
						count++;
						ListofBank.setBalance(ListofBank.getBalance()+amount);
						wallet.setBalance(wallet.getBalance()-amount);
						
						bankDao.save(ListofBank);
						walletDao.save(wallet);
						
						Transaction transaction = new Transaction();
						transaction.setTransactionType("BankToWallet");
						transaction.setTransactionDate(LocalDate.now());
						transaction.setAmount(amount);
						transaction.setDescription("Fund Transfer from Wallet to Bank");
						
						wallet.getTransactions().add(transaction);
						
						transactionDao.save(transaction);
						
					}else {
						throw new InsuficientBalance("Balance is not Sufficient in Wallet");
					}
				}
			
			if(count==0) {
				throw new BankAccountNotFound("Account does not exist");
			}
			
			
			return amount+" Rupee is Credited into Bank";

	}

	@Override
	public Customer getCustomerbyWalletId(Integer wlletId) {
		
		Wallet wallet = walletDao.getById(wlletId);

		Customer customer = wallet.getCustomer();
		
		return customer;
	}


	

	
	
	
	

	
}
