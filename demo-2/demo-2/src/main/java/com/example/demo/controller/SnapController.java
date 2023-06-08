package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnapController 
{
      @GetMapping("/snaplogin")
      public String getLogin(@RequestParam String username,@RequestParam String password)
      {
    	  if(username.equals("Roopa") && password.equals("1234"))
    	  {
    		  return "yes";
    	  }
    	  else
    	  {
    		  return "no";
    	  }
      }
}
