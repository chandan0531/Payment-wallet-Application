package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String customerLogin(@RequestBody CustomerDTO customerDTO) {
		
		return customerLogin.login(customerDTO);
	}
	
	@PatchMapping("/logout")
	public String customerLogout(@RequestParam(required = false) String key) {
		return customerLogin.logOut(key);
	}
}
