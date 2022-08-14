package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.CustomerDTO;
import com.masai.entities.Customer;
import com.masai.entities.UserSession;
import com.masai.exception.InvalidDetailsException;
import com.masai.repository.CustomerDao;
import com.masai.repository.UserSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerAuthenticationImpl implements CustomerAuthentication{

	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	UserSessionDao sessionDao;
	
	@Autowired
	CurrentUserSessionDetailsImpl currentUser;

	@Override
	public String login(CustomerDTO customerDTO) {
	
		
	Optional<Customer> opt = customerDao.findByMobileNumber(customerDTO.getMobileNumber());
	
	if(!opt.isPresent()) {
		
		throw new InvalidDetailsException("Please Check the credentials");
	}
	
	Customer newCustomer1 = opt.get();
	Integer customerId1 = newCustomer1.getCustomerId();
    Optional<UserSession> currentUser =	 sessionDao.findByCustomerId(customerId1);
	
    
     if(newCustomer1.getPassword().equals(customerDTO.getPassword())){
    	
    	String key = RandomString.make(10);
    	
    	UserSession userSession = new UserSession(newCustomer1.getCustomerId(),LocalDateTime.now(),key);

         sessionDao.save(userSession);
         
         return userSession.toString();
    }
    else {
    	return "please enter a valid password";
    }
		
	}

	@Override
	public String logOut(String key) {
		
	 Optional<UserSession> currentUser =	sessionDao.findByUuid(key);
		
	 if(!currentUser.isPresent()) {

		 throw new InvalidDetailsException("Entered key is wrong");
	 }
	 
	 UserSession userSession =  this.currentUser.getcurrentUserSessionDetails(key);
	 
	 sessionDao.delete(userSession);

	 return "Logged Out";
	}

    


}
