package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.BillPayment;
import com.masai.service.BillPaymentService;

@RestController
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService billPayService;
	
	@PostMapping("/bill")
	public BillPayment saveBillHandler(@RequestBody BillPayment bill) {
		BillPayment b1 = billPayService.addBillPayment(bill);
		return b1;
	}

}
