package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.CustomerDTO;
import com.masai.service.CustomerAuthenticationImpl;

@RestController
public class AuthenticationController {

	@Autowired
	CustomerAuthenticationImpl customerLogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> customerLogin(@RequestBody CustomerDTO customerDTO) {
		
		  String customer =  customerLogin.login(customerDTO);
		  
		  return new ResponseEntity<String>(customer,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/logout")
	public ResponseEntity<String> customerLogout(@RequestParam(required = false) String key) {
	   String customer	=  customerLogin.logOut(key);
	   
	   return new ResponseEntity<String>(customer,HttpStatus.ACCEPTED);
	} 
}
