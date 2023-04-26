package com.projectreview1.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
  public Animal updateAAnimal(Animal a)
  {
	  Animal obj = aniRepository.save(a);
	  return obj;
  }
  public void deleteAnimal(int count)
  {
	  aniRepository.deleteById(count);
  }
  public List<Animal> sortAnimals(String field)
  {
	  return aniRepository.findAll(Sort.by(field));
  }
  
}
