package com.petShop1.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.petShop1.demo.Model.Signup;
import com.petShop1.demo.Repository.signUpRep;
@Service
public class signupService 
{
    @Autowired
    signUpRep sigRep;
	public Signup post(Signup s) 
	{
		
		return sigRep.save(s);
	}

}
