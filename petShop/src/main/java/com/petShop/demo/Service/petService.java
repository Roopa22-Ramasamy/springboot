package com.petShop.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.petShop.demo.Model.Pet;
import com.petShop.demo.Repository.petRepository;

import jakarta.transaction.Transactional;


@Service
public class petService 
{
	@Autowired
	petRepository ptRepository;
	public List<Pet> getAllPet()
	  {
	      List<Pet> petList = ptRepository.findAll();
	      return petList;
	  }
	  public Pet savePet(Pet p)
	  {
		  Pet obj = ptRepository.save(p);
		  return obj;
	  }
	  public Pet updatePet(Pet p)
	  {
		  return ptRepository.save(p);
	  }
		 //Optional<Pet> optional = ptRepository.findById(age);
//		 		 if (optional.isPresent()) {
//		        Pet pet = optional.get();
//		        pet.setName(p.getName());
//		        pet.setBreed(p.getBreed());
//		        pet.setAge(p.getAge());
//		        pet.setColor(p.getColor());
//		        pet.setAmount(p.getAmount());
//		        return ptRepository.save(pet);
//		    }
//		return null;
//		 		//throw new RuntimeException("Pet not found with age: " + age);
	
	  public void deletePet(int age)
	  {
		  ptRepository.deleteById(age);
	  }
	  public List<Pet> sortPet(String field)
	  {
		  //return ptRepository.findAll(Sort.by(field));
		 return ptRepository.findAll(Sort.by(Direction.DESC,field));
	  }
	  public List<Pet> pagingPet(int offset, int pagesize) 
	  {
		
		  PageRequest paging = PageRequest.of(offset,pagesize);
		  Page<Pet> ptData = ptRepository.findAll(paging);
		  List<Pet> ptList = ptData.getContent();
		  return ptList;
	  }
	   public List<Pet> pagingAndSortingAnimals(int offset, int pagesize, String field) 
	  {
		   PageRequest paging = PageRequest.of(offset,pagesize).withSort(Sort.by(field));
		   Page<Pet> pt = ptRepository.findAll(paging);
		   return pt.getContent();
	  }
	public List<Pet> fetchPetByNamePrefix(String prefix) 
	{
		
		return ptRepository.findByBreedStartingWith(prefix);
	}
	public List<Pet> fetchPetByNameSuffix(String suffix) 
	{
		
		return ptRepository.findByBreedEndingWith(suffix);
	}
////	public List<Pet> fetchStudentsByNameBreed(String breed) 
//	{
//		
//		return ptRepository.findByBreed(breed);
//	}
	public List<Pet> getPetByAnimalCode(int animalcode, String breed) 
	{
		
		return ptRepository.getPetByAnimalCode(animalcode,breed);
	}
	@Transactional
	public int deletePetByAnimalCode(int animalcode) 
	{
		
		return ptRepository.deletePetByAnimalCode(animalcode);
	}
	@Transactional
	public int updatePetByAnimalCode(int animalcode, String breed) 
	{
		
		return ptRepository.updatePetByDetail(animalcode,breed);
	}
	public List<Pet> fetchPetByBreed(String breed)
	{
		
		return ptRepository.fetchPetByBreed(breed);
	}
	   
		
}