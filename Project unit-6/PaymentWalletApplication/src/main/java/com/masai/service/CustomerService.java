package com.masai.service;

import com.masai.DTO.CustomerDTO;
import com.masai.entities.Customer;

public interface CustomerService {

	public CustomerDTO createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer, String key);
}
