package com.masai.service;

import java.util.List;

import com.masai.entities.BillPayment;

public interface BillPaymentService {
	
	public String addBillPayment(BillPayment payment, Integer wallId,  String key);
	
	public List<BillPayment> viewBillPayment();

}
