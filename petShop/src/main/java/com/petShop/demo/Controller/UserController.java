package com.petShop.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petShop.demo.Model.Registration;
import com.petShop.demo.Service.userService;


@RestController
@CrossOrigin
public class UserController 
{
     @Autowired
     userService uService;
	
     @PostMapping("/login")
      public String login(@RequestBody Map<String,String> loginData)
      {
    	 String username = loginData.get("username");
    	 String password = loginData.get("password");
   	 String result = uService.checkLogin(username,password);
   	 return result;
    	
      }
       @PostMapping("/addusersss")
       public Registration AddUser(@RequestBody Registration u)
       {
    	   return uService.addUser(u);
       }
       @GetMapping("/add")
       public List<Registration> listAll()
       {
    	   return uService.getUser();
    	 
       }
       @PutMapping(value="/put/{id}")
       public Registration updateUser(@RequestBody Registration us,@PathVariable int id)
       {
    	   return uService.updateUser(us,id);
       }
     
}
