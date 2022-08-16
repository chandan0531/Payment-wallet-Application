package com.masai.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.BankAccount;
import com.masai.entities.Customer;
import com.masai.service.WalletService;


@RestController
public class WalletController {
	
	@Autowired
	private WalletService walletService;
	
	@GetMapping("showbalance")
	public double showBalanceController(@RequestParam(required = false) String key) {
		
		return walletService.showBalance(key);
		
	}
	
	@PostMapping("addmoney/{amount}/{Accno}")
	public ResponseEntity<String> addMoneyController(@PathVariable double amount, @RequestParam(required = false) String key,@PathVariable Integer Accno) {
		
		String message =  walletService.addMoney(amount, key, Accno);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);

	}
	
	@PostMapping("depositmoney/{amount}/{Accno}")
	public ResponseEntity<String> depositMoneyController(@PathVariable double amount, @RequestParam(required = false) String key,@PathVariable Integer Accno) {
		
		String message =  walletService.depositAmount(amount, key, Accno);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);

	}
	
	@PostMapping("fundtransfer/{amount}/{sourceno}/{targetno}")
	public ResponseEntity<String> addMoneyController(@PathVariable double amount ,@PathVariable String sourceno,@PathVariable String targetno,@RequestParam(required = false) String key) {
		
		String message =  walletService.fundTransfer(sourceno, targetno, amount, key);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);

	}
	
	@GetMapping("getcustomerbywalletid/{walletId}")
	public ResponseEntity<Customer> getCustomerController(@PathVariable Integer walletId) {
		
		Customer customer = walletService.getCustomerbyWalletId(walletId);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
		
	}

}
