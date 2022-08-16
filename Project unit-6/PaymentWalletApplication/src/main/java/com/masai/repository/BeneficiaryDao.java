package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.BeneficiaryDetails;

public interface BeneficiaryDao extends JpaRepository<BeneficiaryDetails, String>{

}
