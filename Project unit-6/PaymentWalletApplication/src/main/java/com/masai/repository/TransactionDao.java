package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Transaction;


@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {

}
