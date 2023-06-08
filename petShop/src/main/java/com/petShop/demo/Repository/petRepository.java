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
		@Query("select p from Pet p where p.animalcode=?1 and p.breed=?2")
	     public List<Pet> getPetByAnimalCode(int animalcode,String breed);
		
		//named parameter
		@Query("select p from Pet p where p.animalcode=:animalcode")
	    public List<Pet> getSPetByAnimalCode(int animalcode);
		
		//DML
		@Modifying
		@Query("delete from Pet p where p.animalcode=?1")
		public int deletePetByAnimalCode(int animalcode);
		
		@Modifying
		@Query("update Pet p set p.animalcode=?1 where p.breed=?2")
		public int updatePetByDetail(int animalcode,String breed);
		
		//native query
		@Query(value="select * from Pet p where p.breed=?",nativeQuery=true)
		public List<Pet> fetchPetByBreed(String breed);
		
		//jPa derived queries
		 List<Pet> findByBreedStartingWith(String prefix);
		 List<Pet> findByBreedEndingWith(String suffix);
		 //List<Pet> findByBreed(String breed);
		
		
}
