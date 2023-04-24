package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class InstaController 
{
	  @GetMapping("/getpost")
      public String getPost(@RequestParam String username)
      {
    	  return "The post is ready for "+username;
      }
}
