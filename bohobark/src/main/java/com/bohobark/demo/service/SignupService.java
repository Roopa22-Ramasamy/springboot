package com.bohobark.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bohobark.demo.model.Signup;
import com.bohobark.demo.repository.SignupRep;

@Service
public class SignupService 
{
     @Autowired
     SignupRep signRep;
	public Signup save(Signup s) 
	{
		
		return signRep.save(s);
	}

	public String checkLogin(String username, String password) 
	{
		Signup u = signRep.findByUsername(username);
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
				return "Login Failed.Please do Signup" ;
			}
		}
	}
	public String forgetData(String username, String password)  {
  	  Signup user = signRep.findByUsername(username);
        if (user == null) {
            return "No User Found\nPlease Try Again!!!!";
        } else {
           
            if (user.getUsername().equals(username)) {
          	  
//                if (user.getPassword().equals(password)) {
//                    return "Login Successful";
//                } else {
//                    return "Login Failed";
//                }
          	  user.setPassword(password);
          	signRep.save(user);
          	  return "password has changed sucessfully";
            } else {
                return "Login Failed";
            }
        }
  }
}
	
	



	


