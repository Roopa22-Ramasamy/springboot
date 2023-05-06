package com.petShop.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.petShop.demo.Model.Pet;
import com.petShop.demo.Service.petService;

import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
public class petController 
{
	@Autowired
    petService ptService;
	@Tag(name="DisplayAllDetails",description="getAll")
    @GetMapping("/fetchdata")
    public List<Pet> getAllPet()
    {
   	 List<Pet> petList = ptService.getAllPet();
   	 return petList;
    }
	//
	@Tag(name="AddAllNewDetails",description="add")
    @PostMapping(value="/savePet") //add
    public Pet savePet(@RequestBody Pet p)
    {
   	 return ptService.savePet(p);
    }
	@Tag(name="UpdatingDetails",description="update")
    @PutMapping(value="/updatePet/{animalCode}")
    public Pet updatePet(@RequestBody Pet p,@PathVariable int animalCode)
    {
   	 return ptService.updatePet(p,animalCode);
    }
	@Tag(name="DeleteDetails",description="delete")
    @DeleteMapping(value="/deletePet/{animalCode}")
    public void deletePet(@PathVariable("animalCode") int animalCode)
    {
   	 ptService.deletePet(animalCode);
    }
	@Tag(name="SortDetails",description="sort")
    @GetMapping("/sortPet/{field}")
    public List<Pet> sortpet(@PathVariable String field)
    {
   	 return ptService.sortPet(field);
    }
	@Tag(name="pagination",description="paging")
    @GetMapping("/pagingPet/{offset}/{pagesize}")
    public List<Pet> pagingPet(@PathVariable int offset,@PathVariable int pagesize)
    {
   	 return ptService.pagingPet(offset,pagesize);
    }
	@Tag(name="pagingAndSortingDetails",description="pagingAndSorting")
    @GetMapping("/pagingAndSortingPet/{offset}/{pagesize}/{field}")
    public List<Pet> pagingAndSortingAnimals (@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
   	 return ptService.pagingAndSortingAnimals(offset,pagesize,field);
    }
	@Tag(name="fetchDetailsByPrefix",description="prefix")
    @GetMapping("/fetchPetByNamePrefix")
    public List<Pet> fetchPetByNamePrefix(@RequestParam String prefix)
	    {
		return ptService.fetchPetByNamePrefix(prefix);
		
	    }
	@Tag(name="fetchDetailsBySuffix",description="suffix")
    @GetMapping("/fetchPetByNameSuffix")
    public List<Pet> fetchPetByNameSuffix(@RequestParam String suffix)
    {
 	   return ptService.fetchPetByNameSuffix(suffix);
    }
//    @GetMapping("/fetchPetByNameBreed")
//    public List<Pet> fetchStudentsByNameBreed(@RequestParam String breed)
//    {
// 	   return ptService.fetchStudentsByNameBreed(breed);
// 	   
//    }
	@Tag(name="fetchDetailsByAnimalCodeAndBreed",description="fetch")
    @GetMapping("/fetchPet/{animalCode}/{breed}")
    public List<Pet> fetchPetByanimalCode(@PathVariable int animalCode,@PathVariable String breed)
    {
 	   return ptService.getPetByAnimalCode(animalCode,breed);
    }
	@Tag(name="DeleteDetailsByAnimalCode",description="delete")
    @DeleteMapping("/deletePetByAnimalCode/{animalCode}")
    public String deletePetByAnimalCode(@PathVariable int animalCode)
    {
 	   int result = ptService.deletePetByAnimalCode(animalCode);
 	   if(result>0)
 		     return "animal record deleted";
 	   else
 		     return "Problem occured while deleting";
 		     	
    }
	@Tag(name="updateDetails",description="update")
   @PutMapping("/updatePet/{animalCode}/{breed}")
    public int updatePetByAnimalCode(@PathVariable int animalCode,@PathVariable String breed)
    {
 	   return ptService.updatePetByAnimalCode(animalCode, breed);
 	  
    }
	@Tag(name="fetchDetailsByBreed",description="fetch")
   @GetMapping("/fetchPetByBreed/{breed}")
   public List<Pet> fetchPetByBreed(@PathVariable String breed)
   {
 	  return ptService.fetchPetByBreed(breed);
   }
    
}
