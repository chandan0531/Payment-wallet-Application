package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> a79315d1c20025b14b6cbf462b02d566befcde87
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.BillPayment;
import com.masai.service.BillPaymentService;

@RestController
public class BillPaymentController {
	
	@Autowired
	private BillPaymentService billPayService;
	
<<<<<<< HEAD
	@PostMapping("/bills/{walletId}")
	public BillPayment addBill(@RequestBody BillPayment pay,
													@PathVariable("walletId") Integer wallId
=======
	@PostMapping("/bills")
	public BillPayment addBill(@RequestBody BillPayment pay,
													@RequestBody Integer wallId
>>>>>>> a79315d1c20025b14b6cbf462b02d566befcde87
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
