package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.BankAccount;

@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Integer> {

//	public BankAccount findBybankNameAndwalletId(String bankName, Integer walletId);
	
}
