package com.masai.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(unique = true)
	private Integer customerId;
	
	
	private LocalDateTime dateTime;
	private String uuid;
	
	
	public UserSession(Integer customerId, LocalDateTime dateTime, String uuid) {
		super();
	
		this.customerId = customerId;
		this.dateTime = dateTime;
		this.uuid = uuid;
	}
	
	
	
}