package com.login.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.registration.model.User;
import com.login.registration.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registerUser") 
	public User registerUser(@RequestBody User user)throws Exception
	{
		String tempEmailId=user.getEmailId();
		if(tempEmailId!=null && !"".equals(tempEmailId))
		{
			User userObj=service.fetchByEmailId(tempEmailId);
			if(userObj!=null)
			{
				throw new Exception("user with "+tempEmailId+ " already exists");
			}
				
		}
			
		User userObj=null;
		userObj=service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/loginUser")
	public User loginUser(@RequestBody User user)throws Exception
	{
		String tempEmailId =user.getEmailId();
		String tempPassword =user.getPassword();
		User userobj=null;
		if(tempEmailId!=null && tempPassword !=null)
		{
			userobj=service.fetchByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if(userobj==null)
			throw new Exception("Invalid credentials");
		return userobj;
	}
}
