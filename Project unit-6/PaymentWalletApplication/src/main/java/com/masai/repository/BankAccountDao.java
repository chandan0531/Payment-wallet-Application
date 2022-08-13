package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.BankAccount;

@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Integer> {

	public BankAccount findByBankNameAndWalletId(String bankName, Integer walletId);
	
	public Optional<BankAccount> findByAccountNo(Integer accountNo);
}
