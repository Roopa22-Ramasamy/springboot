package com.projectreview1.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import com.projectreview1.demo.Repository.AnimalRepository;
import com.projectreview1.demo.models.Animal;

@Service
public class Animalservice 
{
  @Autowired
  AnimalRepository aniRepository;
  
  public List<Animal> getAllAnimal()
  {
      List<Animal> aniList = aniRepository.findAll();
      return aniList;
  }
  public Animal saveAnimal(Animal a)
  {
	  Animal obj = aniRepository.save(a);
	  return obj;
  }
  public Animal updateAnimal(Animal a,int count)
  {
	 Optional<Animal> optional = aniRepository.findById(count);
	 Animal obj = null;
	 if(optional.isPresent())
	 {
		 obj = optional.get();
		 aniRepository.save(a);
	 }
	  return obj;
  }
  public void deleteAnimal(int count)
  {
	  aniRepository.deleteById(count);
  }
  public List<Animal> sortAnimals(String field)
  {
	  //return aniRepository.findAll(Sort.by(field));
	  return aniRepository.findAll(Sort.by(Direction.DESC,field));
  }
  public List<Animal> pagingAnimals(int offset, int pagesize) 
  {
	
	  PageRequest paging = PageRequest.of(offset,pagesize);
	  Page<Animal> aniData = aniRepository.findAll(paging);
	  List<Animal> aniList = aniData.getContent();
	  return aniList;
  }
   public List<Animal> pagingAndSortingAnimals(int offset, int pagesize, String field) 
  {
	   PageRequest paging = PageRequest.of(offset,pagesize).withSort(Sort.by(field));
	   Page<Animal> ani = aniRepository.findAll(paging);
	   return ani.getContent();
  }
   public List<Animal> fetchAnimalsByNamePrefix(String prefix)
	{
		return aniRepository.findByNameStartingWith(prefix);
		
	}
	public List<Animal> fetchAnimalsByNameSuffix(String suffix)
	{
		return aniRepository.findByNameEndingWith(suffix);
		
	}
	public List<Animal> fetchAnimalsByNameType(String type)
	{
		return aniRepository.findByType(type);
	}
  
}
