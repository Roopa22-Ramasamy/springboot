package com.petShop.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petShop.demo.Model.Pet;
import com.petShop.demo.Service.petService;



@RestController
public class petController 
{
	@Autowired
    petService ptService;
    @GetMapping("/fetchdata")
    public List<Pet> getAllPet()
    {
   	 List<Pet> petList = ptService.getAllPet();
   	 return petList;
    }
    
    @PostMapping(value="/savePet") //add
    public Pet savePet(@RequestBody Pet p)
    {
   	 return ptService.savePet(p);
    }
    @PutMapping(value="/updatePet/{animalCode}")
    public Pet updatePet(@RequestBody Pet p,@PathVariable int animalCode)
    {
   	 return ptService.updatePet(p,animalCode);
    }
    @DeleteMapping(value="/deletePet/{animalCode}")
    public void deletePet(@PathVariable("animalCode") int animalCode)
    {
   	 ptService.deletePet(animalCode);
    }
    @GetMapping("/sortPet/{field}")
    public List<Pet> sortpet(@PathVariable String field)
    {
   	 return ptService.sortPet(field);
    }
    @GetMapping("/pagingPet/{offset}/{pagesize}")
    public List<Pet> pagingPet(@PathVariable int offset,@PathVariable int pagesize)
    {
   	 return ptService.pagingPet(offset,pagesize);
    }
    @GetMapping("/pagingAndSortingPet/{offset}/{pagesize}/{field}")
    public List<Pet> pagingAndSortingAnimals (@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
   	 return ptService.pagingAndSortingAnimals(offset,pagesize,field);
    }
    
}
