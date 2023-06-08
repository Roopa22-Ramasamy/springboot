package com.petSShop1.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.petShop1.demo.Model.PetShop1;
import com.petShop1.demo.Repository.petShop1Repo;




@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class petShop1Contoller 
{
    @Autowired
    private petShop1Repo petRep;
    @GetMapping("/animal")
    public List<PetShop1> getAllAnimal()
    {
 	   return petRep.findAll();
    }
    
    @PostMapping("/animal")
   	public PetShop1 createUser(@RequestBody  PetShop1 p)
   	{
   		return petRep.save(p);
   	}
}
