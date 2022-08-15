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
<<<<<<< HEAD
<<<<<<< HEAD
	private TransactionServiceImpl trService;
	
=======
<<<<<<< HEAD
=======

>>>>>>> 34c3d0c112805e08a376d5ab8ece08a8d696e2eb

	private TransactionServiceImpl trService;


	private TransactionServiceImpl trService;

	private WalletDao wDao;
<<<<<<< HEAD
>>>>>>> a79315d1c20025b14b6cbf462b02d566befcde87
>>>>>>> 8e6bf32a71dcea0ffc67e2c430e55fce8b0dbb84
	
	@Autowired
	private UserSessionDao sessionDao;
=======

	
	@Autowired
	private UserSessionDao sessionDao;

>>>>>>> 34c3d0c112805e08a376d5ab8ece08a8d696e2eb

	@Override
	public BillPayment addBillPayment(BillPayment payment, Integer wallId) {
		Wallet wallet =payment.getWallet();//100
		
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> a79315d1c20025b14b6cbf462b02d566befcde87
>>>>>>> 8e6bf32a71dcea0ffc67e2c430e55fce8b0dbb84
=======

>>>>>>> 34c3d0c112805e08a376d5ab8ece08a8d696e2eb
		Transaction tr = new Transaction();
		
		tr.setAmount(payment.getAmount());
		tr.setDescription(payment.getBillType());
		tr.setTransactionDate(LocalDate.now());
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
		Integer wallId =2;
>>>>>>> a79315d1c20025b14b6cbf462b02d566befcde87
>>>>>>> 8e6bf32a71dcea0ffc67e2c430e55fce8b0dbb84
//		Wallet wallet =payment.getWallet();//100
//		Double amt = wallet.getBalance();
=======

	
>>>>>>> 34c3d0c112805e08a376d5ab8ece08a8d696e2eb
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
<<<<<<< HEAD
				

=======

			
				trService.addTansaction(tr);
			}
			}
				
				
				
			}
			
		}
<<<<<<< HEAD
>>>>>>> f0bddef76e01b1dcd13b1714c8c3452ebc9d715a
>>>>>>> a79315d1c20025b14b6cbf462b02d566befcde87
>>>>>>> 8e6bf32a71dcea0ffc67e2c430e55fce8b0dbb84
=======

>>>>>>> 34c3d0c112805e08a376d5ab8ece08a8d696e2eb
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
