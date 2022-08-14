package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BillPayment;
import com.masai.entities.Wallet;
import com.masai.repository.BillPaymentDao;
import com.masai.repository.WalletDao;

@Service
public class BillPaymentServiceImpl implements BillPaymentService {
	
	@Autowired
	private BillPaymentDao billDao;
	
	@Autowired
	private WalletDao wDao;

	@Override
	public BillPayment addBillPayment(BillPayment payment) {
		
		Integer wallId =10;
//		Wallet wallet =payment.getWallet();//100
//		Double amt = wallet.getBalance();
		Double debitamt = payment.getAmount();
		Wallet w1;
		Double bal;
		Optional<Wallet> opt = wDao.findById(wallId);
		if(opt.isPresent()) {
			 w1 =opt.get();
			 bal =w1.getBalance();
			if(bal>=debitamt) {
				w1.setBalance(bal-debitamt);
				wDao.save(w1);
			}
		}
		else {
			System.out.println("insuff");
		}
		
		 
		 billDao.save(payment);
//		 System.out.println(payment.getWallet().getBalance());
		
		
//		System.out.println("demo");
		
		return payment;
	}

	@Override
	public BillPayment viewBillPayment(BillPayment payment) {
		// TODO Auto-generated method stub
		return null;
	}

}
