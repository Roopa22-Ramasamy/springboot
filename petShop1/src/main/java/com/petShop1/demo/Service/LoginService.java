package com.petShop1.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.petShop1.demo.Model.Login;
import com.petShop1.demo.Repository.LoginRepo;

@Service
public class LoginService 
{
     @Autowired
     LoginRepo logRep;
	public Login addUser(Login l) 
	{
		
		return logRep.save(l);
	}
	public List<Login> getUser() 
	{
		
		return logRep.findAll();
	}
	

}
