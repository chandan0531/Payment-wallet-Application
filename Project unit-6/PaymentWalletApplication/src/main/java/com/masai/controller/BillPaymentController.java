package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.BillPayment;
import com.masai.service.BillPaymentService;

@RestController
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService billPayService;
	
	@PostMapping("/bills/{walletId}")
	public BillPayment addBill(@RequestBody BillPayment pay,
													@PathVariable("walletId") Integer wallId
			) {
		return billPayService.addBillPayment(pay,wallId);
	}
	
	@GetMapping("/bills")
	public List<BillPayment> getBillDetails(@RequestBody BillPayment pay,
			@RequestBody Integer wallId
			){
		return billPayService.viewBillPayment(pay, wallId);
		
		
	}

}
