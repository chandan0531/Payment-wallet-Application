package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BillPayment;
import com.masai.repository.BillPaymentDao;
import com.masai.repository.TransactionDao;
import com.masai.repository.WalletDao;

@Service
public class BillPaymentServiceImpl implements BillPaymentService {
	
	@Autowired
	private BillPaymentDao billDao;
	
	@Autowired
	private TransactionDao trDao;
	
	@Autowired
	private WalletDao wallDao;

	@Override
	public BillPayment addBillPayment(BillPayment payment) {
		
		System.out.println("demo");
//		Transaction tr = new Transaction();
//		tr.setAmount(payment.getAmount());
		
//		payment.getTrans().setAmount(payment.getAmount());
//
//		payment.getTrans().setDescription(payment.getBillType());
//		payment.getTrans().setTransactionDate(payment.getPaymentDate());
//		payment.getTrans().setAmount(payment.getAmount());
//		payment.getTrans().setWallet(payment.getWallet());
//		Double amt = payment.getAmount();
//		BigDecimal bd = payment.getWallet().getBalance();
//		Double doubleVal=bd.doubleValue();
//		
//		trDao.save(payment.getTrans());
//		billDao.save(payment);
		
//		Wallet wl =payment.
//		if(amt < doubleVal) {
//			Double debit = doubleVal-amt;
//			wallDao.save(payment.getWallet(null))
//		}
//		
		
		return payment;
	}

	@Override
	public BillPayment viewBillPayment(BillPayment payment) {
		// TODO Auto-generated method stub
		return null;
	}

}
