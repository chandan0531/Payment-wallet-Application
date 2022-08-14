package com.masai.userSessions;

import com.masai.entities.Customer;
import com.masai.entities.Wallet;

public interface UserSessions {
	
	public Wallet getCustomerWallet(String key);
	
	public Customer getCustomer(String key);

}
