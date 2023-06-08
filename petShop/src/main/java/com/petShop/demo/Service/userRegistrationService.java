package com.petShop.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petShop.demo.Model.Registration;
import com.petShop.demo.Repository.userRegistrationRepository;


@Service
public class userRegistrationService 
{
    @Autowired
    userRegistrationRepository usrRegistrationRepository;
	public Registration saveRegistration(Registration r) 
	{
		return usrRegistrationRepository.save(r);
	}
	public List<Registration> getAllUsers() 
	{
		 List<Registration> petList = usrRegistrationRepository.findAll();
      return petList;
	}
    
    

}
