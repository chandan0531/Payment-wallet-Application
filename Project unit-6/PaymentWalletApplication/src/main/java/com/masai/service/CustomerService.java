package com.masai.service;

import com.masai.entities.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer, String key);
}
