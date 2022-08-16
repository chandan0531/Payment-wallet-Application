package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.CashbackImpl;

@RestController
public class CashbackController {

	
	@Autowired
	CashbackImpl cashback;
	
	@GetMapping("/cashback/{billId}/{walletId}")
	public ResponseEntity<String> cashback(@PathVariable Integer billId,@PathVariable Integer walletId,@RequestParam(required = false) String promocode) {
		
	String cash =	cashback.Calculatecashback(billId,walletId, promocode);
		
	
	return new ResponseEntity<String>(cash,HttpStatus.ACCEPTED);
		
		
	}
	
	
}
