package com.masai.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserService {

	@Id
	@Min(value = 10,message = "Mobile Number must be of 10 digits")
    @Max(value = 10)
	@Pattern(regexp = "[0-9]{10}", message = "Mobile No is Invalid")
	private String mobileNumber;
	
	@NotNull(message = "password should not be null")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$")
	private String password;
}
