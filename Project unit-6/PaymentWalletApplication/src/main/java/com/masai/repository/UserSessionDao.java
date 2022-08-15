package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.UserSession;

@Repository
public interface UserSessionDao extends JpaRepository<UserSession,Integer >{

	public Optional<UserSession> findByCustomerId(Integer customerId);
	
	public Optional<UserSession> findByUuid(String uuid);

	public void save(String uuid);

	
}
