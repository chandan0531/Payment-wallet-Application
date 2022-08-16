package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.Cashback;

public interface CashbackDao extends JpaRepository<Cashback, String> {

	public Optional<Cashback> findByPromocode(String promocode);

}
