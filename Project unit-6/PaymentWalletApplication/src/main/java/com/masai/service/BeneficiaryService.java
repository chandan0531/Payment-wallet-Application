package com.masai.service;

import java.util.List;

import com.masai.entities.BeneficiaryDetails;
import com.masai.entities.Customer;

public interface BeneficiaryService {
	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails bd);
	public BeneficiaryDetails deleteBeneficiary(BeneficiaryDetails bd);
	public BeneficiaryDetails viewBeneficiary(String mobNo);
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer);
}
