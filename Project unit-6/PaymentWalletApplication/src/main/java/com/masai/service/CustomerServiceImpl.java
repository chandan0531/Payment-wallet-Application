package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Customer;
import com.masai.entities.UserSession;
import com.masai.entities.Wallet;
import com.masai.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
    private CustomerDao customerDao;
	
	@Autowired
	CurrentUserSessionDetailsImpl currentuser;
	
	@Override
	public Customer createCustomer(Customer customer) {
		
	   Optional<Customer> opt = customerDao.findByMobileNumber(customer.getMobileNumber());
		
	   if(opt.isPresent()){
		  System.out.println("User Already Exist"); 
	   }
	   
	   
	   
	   return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) {
		
    UserSession customer2 =	currentuser.getcurrentUserSessionDetails(key);
		
  if(customer2==null) {
	  System.out.println("no user found");
  }

  return customerDao.save(customer);
 

	}

	
}
