package com.Educational.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Educational.demo.Model.userModel;
import com.Educational.demo.Repository.userRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController 
{
       @Autowired
       private userRepository userRep;
       //get all users
       @GetMapping("/users")
       public List<userModel> getAllUser()
       {
    	   return userRep.findAll();
       }
       
    // create employee 
   	@PostMapping("/users")
   	public userModel createUser(@RequestBody userModel u)
   	{
   		return userRep.save(u);
   	}
}
