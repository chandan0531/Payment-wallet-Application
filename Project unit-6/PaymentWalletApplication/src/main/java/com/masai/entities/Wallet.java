package com.masai.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId;
	@Min(value = 0, message="Balance Should be greater than zero")
	@NotNull
	private BigDecimal balance;
	
}
