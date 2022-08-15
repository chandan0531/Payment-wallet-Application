package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BillPayment;
import com.masai.entities.Transaction;
import com.masai.entities.Wallet;
import com.masai.exception.BillPaymentNotFoundException;
import com.masai.repository.BillPaymentDao;
import com.masai.repository.UserSessionDao;
import com.masai.repository.WalletDao;

import net.bytebuddy.utility.RandomString;

@Service
public class BillPaymentServiceImpl implements BillPaymentService {
	
	@Autowired
	private WalletDao wDao;
	
	@Autowired
	private BillPaymentDao billDao;
	
	@Autowired


	private TransactionServiceImpl trService;


	private TransactionServiceImpl trService;

	private WalletDao wDao;

	
	@Autowired
	private UserSessionDao sessionDao;


	@Override
	public BillPayment addBillPayment(BillPayment payment, Integer wallId) {
		Wallet wallet =payment.getWallet();//100
		

		Transaction tr = new Transaction();
		
		tr.setAmount(payment.getAmount());
		tr.setDescription(payment.getBillType());
		tr.setTransactionDate(LocalDate.now());

	
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
				trService.addTansaction(tr);
			}
			}

			
				trService.addTansaction(tr);
			}
			}
				
				
				
			}
			
		}

		else {
			throw new BillPaymentNotFoundException("Insufficient amount ");
		}
		
		 
		return  billDao.save(payment);
	}

	@Override
	public List<BillPayment> viewBillPayment(BillPayment payment, Integer wallId) {
		Wallet w = payment.getWallet();
		List<BillPayment> billList = w.getBillpayment();
		if(billList.size()==0) {
			throw new BillPaymentNotFoundException("No BillPaymets in the List ");
		}
		
				
		return billList;
	}


}
