package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.Wallet;

public interface WalletDao extends JpaRepository<Wallet, Integer>{

}
