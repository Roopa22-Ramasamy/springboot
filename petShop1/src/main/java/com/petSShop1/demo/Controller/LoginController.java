package com.petSShop1.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petShop1.demo.Service.LoginService;

import com.petShop1.demo.Model.Login;

@RestController
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"Content-Type"})
public class LoginController 
{
	@Autowired
	LoginService logSer;
	@PostMapping("/add")
    public Login addUser(@RequestBody Login l)
    {
 	   return logSer.addUser(l);
    }
	@GetMapping("/get")
    public List<Login> listAll()
    {
 	   return logSer.getUser();
 	 
    }
}
