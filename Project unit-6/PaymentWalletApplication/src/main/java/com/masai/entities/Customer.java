package com.masai.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	private Integer customerId;
	
	
	@Pattern(regexp = "[0-9]{10}", message = "Mobile No is Invalid")
	private String mobileNumber;
	
	@NotNull(message = "Name should not be null")
	private String name;
    
	@NotNull(message = "password should not be null")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$")
	private String password;
	
	@Email(message = "Email format is wrong")
	@NotNull(message = "Name should not be null")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
}
