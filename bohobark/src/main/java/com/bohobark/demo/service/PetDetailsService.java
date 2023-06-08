package com.bohobark.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bohobark.demo.model.PetDetails;
import com.bohobark.demo.repository.PetDetailsRepository;


import jakarta.transaction.Transactional;

@Service
public class PetDetailsService 
{
    @Autowired
    PetDetailsRepository petRep; 
	public List<PetDetails> getAllPetDetails() 
	{
		List<PetDetails> petList = petRep.findAll();
		return petList;
	}
	public PetDetails update(PetDetails p,int animalcode) 
	{
		Optional<PetDetails> optional = petRep.findById(animalcode);
		PetDetails obj = null;
		 if (optional.isPresent()) 
		{
            obj = optional.get();
			petRep.saveAndFlush(p);
        }
       return obj;

	}
	public PetDetails savePets(PetDetails p) 
	{
		PetDetails obj = petRep.save(p);
		return obj;
	}
	public void deletePets(int animalcode) 
	{
		petRep.deleteById(animalcode);
		
	}
	public PetDetails getPet(int animalcode) 
	{
		PetDetails p = petRep.findById(animalcode).get();
		   return p;
		
	}
	public List<PetDetails> sortPet(String field) 
	{
		//return petRep.findAll(Sort.by(field)); //ascending
		return petRep.findAll(Sort.by(Direction.DESC,field));  //descending
	}
	public List<PetDetails> pagingPet(int offset, int pagesize) 
	{
		
		PageRequest paging = PageRequest.of(offset,pagesize);
		Page< PetDetails> petData = petRep.findAll(paging);
	    List< PetDetails> petList = petData.getContent();
		return petList;
	}
	public List<PetDetails> pagingAndSortingPet(int offset, int pagesize, String field) 
	{
		PageRequest paging = PageRequest.of(offset,pagesize).withSort(Sort.by(field));
		Page<PetDetails> pet = petRep.findAll(paging);
		return pet.getContent();
		
	}
//	public List<PetDetails> fetchpetByNamePrefix(String prefix)
//	{
//		return petRep.findByNameStartingWith(prefix);
//		
//	}
//
//	public List<PetDetails> fetchPetByNameSuffix(String suffix) 
//	{
//		
//		return petRep.findByNameEndingWith(suffix);
//	}
	public List<PetDetails> getPetByname(String animalname,String animalbreed)
	{
		  return petRep.getPetByname(animalname,animalbreed);
	}
	@Transactional 
	public int deletePetByName(String animalname) 
	{
		
		return petRep.deletePetByname(animalname);
	}
	@Transactional
	public int updatePetByname(String animalbreed, String animalname) 
	{
		
		return petRep.updatePetByname(animalbreed, animalname);
	}
	public List<PetDetails> fetchPetByname(String animalname) 
	{
		
		return petRep.fetchPetByname(animalname);
	}
	
	
	public List<PetDetails> getbyna(String animalname,String animalbreed)
	{
		return petRep.getpetbyname(animalname, animalbreed);
	}
	
	
}















