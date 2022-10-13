package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.CustomerDTO;
import com.masai.service.CustomerServiceImpl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;
	
	
	@PostMapping("/customer")
	public CustomerDTO saveCustomer(@RequestBody com.masai.entities.Customer customer) {
		return customerService.createCustomer(customer);
	}
	
	@PutMapping("/customer")
	public com.masai.entities.Customer updateCustomer(@RequestBody com.masai.entities.Customer customer, @RequestBody(required = false)String key){
		
		return customerService.updateCustomer(customer, key);	}
}
