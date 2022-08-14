package com.masai.userSessions;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.masai.entities.Customer;
import com.masai.entities.UserSession;
import com.masai.entities.Wallet;
import com.masai.exception.UserNotFoundException;
import com.masai.repository.CustomerDao;
import com.masai.repository.UserSessionDao;

@Component
public class UserSessionsImpl implements UserSessions{
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Wallet getCustomerWallet(String key) {
		
		Optional<UserSession> optionaluserSession = userSessionDao.findByUuid(key);
		
		if(!optionaluserSession.isPresent()) {
			throw new UserNotFoundException("Unauthorized key");
		}else {
			
			Integer customerId= optionaluserSession.get().getCustomerId();
			
			Customer customer = customerDao.getById(customerId);
			
			Wallet wallet = customer.getWallet();
			
			return wallet;
		}
		
		
	}

	@Override
	public Customer getCustomer(String key) {
		
		Optional<UserSession> optionaluserSession = userSessionDao.findByUuid(key);
		
		if(!optionaluserSession.isPresent()) {
			throw new UserNotFoundException("Unauthorized key");
		}else {
			
			Integer customerId= optionaluserSession.get().getCustomerId();
			
			Customer customer = customerDao.getById(customerId);
			
			
			return customer;
		}
		
		
	}
	

}
