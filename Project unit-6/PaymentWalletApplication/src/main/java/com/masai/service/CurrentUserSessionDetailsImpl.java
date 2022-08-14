package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.UserSession;
import com.masai.repository.CustomerDao;
import com.masai.repository.UserSessionDao;

@Service
public class CurrentUserSessionDetailsImpl implements CurrentUserSessionDetails{

	@Autowired
	private UserSessionDao sessionDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public UserSession getcurrentUserSessionDetails(String key) {
	
		   Optional<UserSession>  opt = sessionDao.findByUuid(key);
		
		   if(!opt.isPresent()) {
			   System.out.println("unauthorized");
		   }
		   
		   return opt.get();
	}

	
}
