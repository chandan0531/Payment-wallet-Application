package com.masai.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId;
	
	@Min(value = 0, message="Balance Should be greater than zero")
	@NotNull
	private double balance;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
	private List<BankAccount> bankAccount;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "wallet")
	private Customer customer;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
	private List<BillPayment> billpayment;
	
	@JsonIgnore
	@OneToMany
	private List<Transaction> transactions;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "wallet")
	@JsonIgnore
	private List<BeneficiaryDetails> bd = new ArrayList<>();
}
