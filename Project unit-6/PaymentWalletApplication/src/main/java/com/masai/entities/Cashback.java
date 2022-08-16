package com.masai.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Cashback {

	@Id
	private String promocode;
	
	
	

	public Cashback(String promocode) {
		super();
		this.promocode = promocode;
	}

	
	
	
	
	
	
	
	
}
