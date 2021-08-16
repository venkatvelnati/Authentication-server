package com.login.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.registration.model.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer>{
	
	public User findUserByEmailId(String emailId);
	
	public User findUserByEmailIdAndPassword(String emailId, String password);
}
