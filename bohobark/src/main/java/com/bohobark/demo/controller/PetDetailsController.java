package com.bohobark.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bohobark.demo.model.PetDetails;
import com.bohobark.demo.service.PetDetailsService;

@RestController
@CrossOrigin
public class PetDetailsController 
{
    @Autowired
    PetDetailsService petService;
    @GetMapping("/getanimal")
    public List<PetDetails> getAllPetDetails()
    {
    	List<PetDetails> petList = petService.getAllPetDetails();
    	return petList;
    }

    @PutMapping("/update/{animalcode}")
    public PetDetails update(@RequestBody PetDetails p,@PathVariable int animalcode)
    {
    	return petService.update(p,animalcode); 
    }
    @PostMapping("/addpet")
    public PetDetails savePets(@RequestBody PetDetails p)
    {
    	return petService.savePets(p);
    }
    @DeleteMapping("/deletePets/{animalcode}")
    public void deletePets(@PathVariable int animalcode)
    {
    	petService.deletePets(animalcode);
    }
    @GetMapping("/getpet/{animalcode}")
    public PetDetails getPet(@PathVariable int animalcode)
    {
    	return petService.getPet(animalcode);
    }
  @GetMapping("/sortpet/{field}")
  public List<PetDetails> sortPet(@PathVariable String field )
  {
  	   return petService.sortPet(field);
  }
  
@GetMapping("/pagingPet/{offset}/{pagesize}")
public List<PetDetails> pagingPet(@PathVariable int offset,@PathVariable int pagesize)
{
	   return petService.pagingPet(offset,pagesize);
}
@GetMapping("/pagingAndSortingPet/{offset}/{pagesize}/{field}")
public List<PetDetails> pagingAndSortingPet(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
{
	   return petService.pagingAndSortingPet(offset,pagesize,field);
}

//@GetMapping("/fetchPetByNamePrefix")
//public List<PetDetails> fetchpetByNamePrefix(@RequestParam String prefix)
//  {
//	return petService.fetchpetByNamePrefix(prefix);
//	
//  }
//
//@GetMapping("/fetchPetByNameSuffix")
//public List<PetDetails> fetchPetByNameSuffix(@RequestParam String suffix)
//{
//	   return petService.fetchPetByNameSuffix(suffix);
//}
@GetMapping("/fetchPetByName/{animalname}/{animalbreed}")
public List<PetDetails> getPetByname(@PathVariable String animalname,@PathVariable String animalbreed)
{
	   return petService.getPetByname(animalname,animalbreed);
}
@DeleteMapping("/deletePetByName/{animalname}")
public String deletePetByname(@PathVariable String animalname)
{
	   int result = petService.deletePetByName(animalname);
	   if(result>0)
		     return "pet record deleted";
	   else
		     return "Problem occured while deleting";
		     	
}

@PutMapping("/updatepet/{animalbreed}/{animalname}")
public int updatePetByName(@PathVariable String animalbreed,@PathVariable String animalname)
{
	   return petService.updatePetByname(animalbreed,animalname);
	  
}

@GetMapping("/fetchPetByName/{animalname}")
public List<PetDetails> fetchPetByName(@PathVariable String animalname)
{
	  return petService.fetchPetByname(animalname);
}

@GetMapping("/byname/{name1}/{name2}")
public List<PetDetails> showbyname(@PathVariable("name1") String name1,@PathVariable("name2") String name2)
{
	return petService.getbyna(name1, name2);
}
    
}














