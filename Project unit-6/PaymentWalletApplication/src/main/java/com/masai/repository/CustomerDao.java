package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	public Optional<Customer> findByMobileNumber(String mobileNo);
	
}
