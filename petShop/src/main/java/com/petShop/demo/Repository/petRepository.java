package com.petShop.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.petShop.demo.Model.Pet;


@Repository
public interface petRepository extends JpaRepository<Pet,Integer>
{
	//positional parameter,order should match
		@Query("select p from Pet p where p.animalCode=?1 and p.breed=?2")
	     public List<Pet> getPetByAnimalCode(int animalCode,String breed);
		
		//named parameter
		@Query("select p from Pet p where p.animalCode=:animalCode")
	    public List<Pet> getSPetByAnimalCode(int animalCode);
		
		//DML
		@Modifying
		@Query("delete from Pet p where p.animalCode=?1")
		public int deletePetByAnimalCode(int animalCode);
		
		@Modifying
		@Query("update Pet p set p.animalCode=?1 where p.breed=?2")
		public int updatePetByDetail(int animalCode,String breed);
		
		//native query
		@Query(value="select * from Pet p where p.breed=?",nativeQuery=true)
		public List<Pet> fetchPetByBreed(String breed);
		
		//jPa derived queries
		 List<Pet> findByBreedStartingWith(String prefix);
		 List<Pet> findByBreedEndingWith(String suffix);
		 //List<Pet> findByBreed(String breed);
		
		
}
