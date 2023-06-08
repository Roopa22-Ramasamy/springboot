package com.petSShop1.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petShop1.demo.Model.Signup;
import com.petShop1.demo.Service.signupService;

@RestController
public class signupContoller 
{
    @Autowired
    signupService signSer;
    @PostMapping("/posting")
    public Signup post(@RequestBody Signup s)
    {
    	return signSer.post(s);
    }
    
    
    
}
