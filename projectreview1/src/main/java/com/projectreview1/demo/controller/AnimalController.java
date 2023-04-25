package com.projectreview1.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectreview1.demo.models.Animal;
import com.projectreview1.demo.service.Animalservice;

@RestController
public class AnimalController 
{
     @Autowired
     Animalservice aniService;
     @GetMapping("/fetchdata")
     public List<Animal> getAllAnimals()
     {
    	 List<Animal> aniList = aniService.getAllAnimal();
    	 return aniList;
     }
     
     @PostMapping(value="/saveAnimal")
     public Animal saveAnimal(@RequestBody Animal a)
     {
    	 return aniService.saveAnimal(a);
     }
     @PutMapping(value="/updateAnimal")
     public Animal updateStudent(@RequestBody Animal a)
     {
    	 return aniService.saveAnimal(a);
     }
     @DeleteMapping(value="/deleteAnimal/{co}")
     public void deleteAnimal(@PathVariable("co") int count)
     {
    	 aniService.deleteAnimal(count);
     }
}
