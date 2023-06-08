package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.PersonRepository;

import jakarta.transaction.Transactional;

@Service
public class AddressPersonService 
{
   @Autowired
   PersonRepository perRep;
  
   
 
   public List<Person>fetchAllPersons()
   {
	   return perRep.findAll();
	   
   }
 
   public Person savePersons(Person p)
   {
	   return perRep.save(p);
   }
}
