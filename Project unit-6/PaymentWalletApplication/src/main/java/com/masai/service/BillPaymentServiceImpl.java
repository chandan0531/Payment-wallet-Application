package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BillPayment;
import com.masai.repository.BillPaymentDao;

@Service
public class BillPaymentServiceImpl implements BillPaymentService {
	
	@Autowired
	private BillPaymentDao billDao;

	@Override
	public BillPayment addBillPayment(BillPayment payment) {
		
<<<<<<< HEAD
=======
		System.out.println("demo");
		
>>>>>>> b65ea6ddd3dac65b1e0fd5bdb11c3d540807626b
		return null;
	}

	@Override
	public BillPayment viewBillPayment(BillPayment payment) {
		// TODO Auto-generated method stub
		return null;
	}

}
