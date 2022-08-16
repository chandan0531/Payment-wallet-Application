package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.BeneficiaryDetails;
import com.masai.entities.Customer;
import com.masai.service.BeneficiaryService;
@RestController
@RequestMapping("/wallet")
public class BeneficiaryController {
	@Autowired
	private BeneficiaryService bs;
	
	@PostMapping("/addbeneficiary")
	public ResponseEntity<BeneficiaryDetails> bdStore(@Valid @RequestBody BeneficiaryDetails bd) {
		
		BeneficiaryDetails bdetails = bs.addBeneficiary(bd);
		
		return new ResponseEntity<BeneficiaryDetails>(bdetails,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deletebeneficiary")
	public ResponseEntity<BeneficiaryDetails> bdDelete(@Valid @RequestBody BeneficiaryDetails bd ) {
		
		BeneficiaryDetails b = bs.deleteBeneficiary(bd);
		
		return new ResponseEntity<BeneficiaryDetails>(b,HttpStatus.OK);

	}
	
	@GetMapping("/viewbeneficiary/{mobileNumber}")
	public ResponseEntity<BeneficiaryDetails> bdgetbyId(@Valid @PathVariable("mobileNumber") String num){
		
		BeneficiaryDetails b = bs.viewBeneficiary(num);
		
		return new ResponseEntity<BeneficiaryDetails>(b,HttpStatus.OK);
		
	}
	
	@PostMapping("/viewallbeneficiary")
	public ResponseEntity<List<BeneficiaryDetails>> getallbd(@Valid @RequestBody Customer customer){
		
		List<BeneficiaryDetails> b = bs.viewAllBeneficiary(customer);
		
		return new ResponseEntity<List<BeneficiaryDetails>>(b,HttpStatus.OK);
		
	}
	
	
}
