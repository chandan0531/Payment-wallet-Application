package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Transaction;
import com.masai.entities.TransactionType;
import com.masai.entities.Wallet;


@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {
	
	public List<Transaction> findByTransactionType(TransactionType transactionType);
	
	public List<Transaction> findByWallet(Wallet wallet);
}
