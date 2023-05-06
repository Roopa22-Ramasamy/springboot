package com.portalproblem.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController 
{
	@GetMapping("/getAll")
    public String getPost(@RequestParam String username)
    {
  	  return "Welcome "+username;
    }
}
