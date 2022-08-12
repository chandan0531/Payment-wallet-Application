package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.service.UserService;

@Repository
public interface UserServiceDao extends JpaRepository<UserService, String> {

	public String findByMobileNumberAndPassword();
	
}
