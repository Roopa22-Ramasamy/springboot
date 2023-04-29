package com.petShop.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petShop.demo.Model.User;
import com.petShop.demo.Service.userService;

@RestController
public class UserController 
{
     @Autowired
     userService uService;
     @PostMapping("/login")
      public String login(@RequestBody Map<String,String> loginData)
      {
    	 String uname = loginData.get("uname");
    	 String password = loginData.get("password");
    	 String result = uService.checkLogin(uname,password);
    	 return result;
      }
       @PostMapping("/adduser")
       public User AddUser(@RequestBody User u)
       {
    	   return uService.addUser(u);
       }
       @GetMapping("/add")
       public List<User> listAll()
       {
    	   return uService.getUser();
    	 
       }
       @PutMapping(value="/put/{id}")
       public User updateUser(@RequestBody User us,@PathVariable int id)
       {
    	   return uService.updateUser(us,id);
       }
     
}
