package com.masai.service;

import java.util.List;

import com.masai.entities.BillPayment;

public interface BillPaymentService {
	
	public BillPayment addBillPayment(BillPayment payment, Integer wallId);
	
	public List<BillPayment> viewBillPayment(BillPayment payment, Integer wallId);

}
