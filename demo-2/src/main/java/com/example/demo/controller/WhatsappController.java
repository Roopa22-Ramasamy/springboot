package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhatsappController
{
	@GetMapping("/login")
      public String login()
      {
    	  return "Login successful";
      }
	
	@GetMapping("/signin/{userName}")
	public String Signin(@PathVariable("userName") String userName)
			{
		        return "The landing page of the user " +userName;
			}
}
