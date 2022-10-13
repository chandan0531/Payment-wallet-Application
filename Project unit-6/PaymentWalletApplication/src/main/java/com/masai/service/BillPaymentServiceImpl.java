package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BillPayment;
import com.masai.entities.Transaction;
import com.masai.entities.UserSession;
import com.masai.entities.Wallet;
import com.masai.exception.BillPaymentNotFoundException;
import com.masai.exception.UserNotFoundException;
import com.masai.repository.BillPaymentDao;
import com.masai.repository.CashbackDao;
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
	
	@Autowired
	private UserSessionDao sessionDao;
	
	
    @Autowired	
    private CashbackDao cashbackDao;
    
 
    
   





@Override
public String addBillPayment(BillPayment payment, Integer wallId) {
Wallet wallet =payment.getWallet();//100


Transaction tr = new Transaction();

tr.setAmount(payment.getAmount());
tr.setDescription(payment.getBillType());
tr.setTransactionDate(LocalDate.now());

//Integer wallId =2;

Double debitamt = payment.getAmount();
Wallet w1;
Double bal;
String promo = null ;
int count =0;

Optional<Wallet> opt = wDao.findById(wallId);
if(opt.isPresent()) {
w1 =opt.get();
bal =w1.getBalance();
if(bal>=debitamt) {

count++;



w1.setBalance(bal-debitamt);
payment.setWallet(opt.get());
wDao.save(w1);
trService.addTansaction(tr);

billDao.save(payment);
promo = RandomString.make(12);

com.masai.entities.Cashback  c = new com.masai.entities.Cashback(promo);

cashbackDao.save(c);




}
}

else{
throw new BillPaymentNotFoundException("Insufficient amount ");
}



billDao.save(payment);

return "Payment Done Successfully..."+"\n"+
"Use this Promocode To get a CashBack from 5% to 25% : "+promo ;
}


	@Override
	public List<BillPayment> viewBillPayment() {
		
		List<BillPayment> billList = billDao.findAll();
		if(billList.size()==0) {
			throw new BillPaymentNotFoundException("No BillPaymets in the List ");
		}
		
				
		return billList;
	}


	


}
