package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.BillPayment;

@Repository
public interface BillPaymentDao extends JpaRepository<BillPayment, Integer> {

}
