package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BillPayment;
import com.masai.entities.Wallet;
import com.masai.repository.BillPaymentDao;
import com.masai.repository.CashbackDao;
import com.masai.repository.WalletDao;

@Service
public class CashbackImpl implements Cashback{

	
	@Autowired
	CashbackDao cashbackDao;
	
	@Autowired
	WalletDao walletdao;
	
	@Autowired
	WalletService walletService;
	
	@Autowired
	BillPaymentDao billPaymentDao;
	
	
	@Override
	public String Calculatecashback(Integer billId ,Integer walletId, String promocode) {
		
		Optional<com.masai.entities.Cashback> cash =  cashbackDao.findByPromocode(promocode);
		
		 
		 int val = 0;
		 int cashbankPercentage = 0;
		 double prevBal = 0;
		 double currentBal = 0;
		 double amount;
		 
		 if(cash!=null) {
			
			 int max = 25;
			 int min = 5;
			 
			 int range = max - min +1;
			 
			 for(int i=0; i<25; i++) {
				  val = (int) (Math.random()*range)+min;
			 }
			 
		      BillPayment bill =	  billPaymentDao.getById(billId);
			 
		      amount =   bill.getAmount();
		
			 cashbankPercentage = (int) ((amount*val)/100);
			 
			 System.out.println(amount+"aaaaaaaaaaaaaa");
			 
			 System.out.println(val);
			 //System.out.println(cashbankPercentage+"sssssss");
			 //System.out.println(val);
		 }
		 
		 else {
			 return "wrong key";
		 }
		 
		 
	       Wallet wallet =   walletdao.getById(walletId);
	    
	       if(wallet.getWalletId().equals(walletId)) {
	    	  
	    	   prevBal = wallet.getBalance();
	    	   
	    	   wallet.setBalance(wallet.getBalance()+cashbankPercentage);

	    	   walletdao.save(wallet);
	    	   
	    	   currentBal = wallet.getBalance();
	    	   
	       }
	       else {
	    	   return "wallet not found";
	       }
	 
		 
		 
		 
		 return "Hurray!! you got cashback of "+val+" percent"+" "
		+"and total cashback ammount is " +": "+cashbankPercentage+ "\n" +
		 "Previous wallet balance was "+ prevBal +"\n" + 
		 "Updated wallet balance is "+ currentBal;
		 
		 
		 
		
	}

	
	
	
}
