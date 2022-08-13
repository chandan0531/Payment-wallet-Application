package com.masai.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountNo;
	
	@NotNull
	@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}")
	private String ifscCode;
	
	@NotNull
	@Size(min = 7, max = 20, message = "Bank Name must have min 7 and max 15 characters")
	private String bankName;
	
	@NotNull
	@Min(0)
	private double balance;
	
	@ManyToOne
	@JsonIgnore
	private Wallet wallet;	
}
