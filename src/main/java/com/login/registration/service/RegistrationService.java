package com.login.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.registration.model.User;
import com.login.registration.repository.RegistrationRepository;
@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser(User user )
	{
		return repo.save(user);
	}
	
	public User fetchByEmailId(String emailId)
	{
		return repo.findUserByEmailId(emailId);
	}
	
	public User fetchByEmailIdAndPassword(String emailId, String password)
	{
		return repo.findUserByEmailIdAndPassword(emailId, password);
	}
}
