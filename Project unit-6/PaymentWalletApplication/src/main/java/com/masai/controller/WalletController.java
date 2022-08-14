package com.masai.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Customer;
import com.masai.service.WalletService;


@RestController
public class WalletController {
	
	@Autowired
	private WalletService walletService;
	
//	@GetMapping("showbalance/{mobileno}/{password}")
//	public BigDecimal showBalanceController(@PathVariable("mobileno") String mobileno,@PathVariable("password") String password) {
//		
//		return walletService.showBalance(mobileno);
//		
//	}
	
	@PostMapping("addbalance/{amount}/{Accno}")
	public String addMoneyController(@PathVariable double amount, @RequestParam(required = false) String key,@PathVariable Integer Accno) {
		
		return walletService.addMoney(amount, key, Accno);

	}
	
	

}
