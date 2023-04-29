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
	  public Pet updatePet(Pet p,int animalCode)
	  {
		 Optional<Pet> optional = ptRepository.findById(animalCode);
		 Pet obj = null;
		 if(optional.isPresent())
		 {
			 obj = optional.get();
			 ptRepository.save(p);
		 }
		  return obj;
	  }
	  public void deletePet(int animalCode)
	  {
		  ptRepository.deleteById(animalCode);
	  }
	  public List<Pet> sortPet(String field)
	  {
		  //return aniRepository.findAll(Sort.by(field));
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
	   
		
}