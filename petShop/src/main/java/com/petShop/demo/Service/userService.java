package com.petShop.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petShop.demo.Model.Registration;

import com.petShop.demo.Repository.userRepository;

@Service
public class userService 
{
    @Autowired
    userRepository userRep;
	public String checkLogin(String username, String password) 
	{
		Registration u = userRep.findByusername(username) ;
		if(u == null)
		{
			return" No user found " ;
		}
		else
		{
			if(u.getPassword().equals(password))
			{
				return"Login Successfull" ;
			}
			else
			{
				return "Login Failed" ;
			}
		}
	}
	
	public Registration addUser(Registration m)
	{
		return userRep.save(m) ;
	}
	
	public List<Registration> getUser()
	{
		return userRep.findAll() ;
	}
	public Registration updateUser(Registration us,int id)
	{
		Optional<Registration> optional = userRep.findById(id);
		Registration obj = null;
		if(optional.isPresent())
		{
			 obj = optional.get();
			 userRep.save(us);
		}
		return obj;
	}
		
		
	}

