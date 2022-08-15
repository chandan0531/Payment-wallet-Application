package com.masai.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class BeneficiaryDetails {
	@Id
	@Pattern(regexp = "[0-9]{10}", message = "{mobNo.invalid}")
	private String mobileNumber;
	private String name;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="walletId")
//	private Wallet wallet;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public BeneficiaryDetails(String name, String mobileNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
	}
	
	public BeneficiaryDetails() {
		super();
	}
	
}
