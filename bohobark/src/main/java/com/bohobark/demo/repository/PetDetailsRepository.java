package com.bohobark.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bohobark.demo.model.PetDetails;



@Repository
public interface PetDetailsRepository extends JpaRepository<PetDetails,Integer>
{
     //jpa derived queries
//	List<PetDetails> findByNameStartingWith(String prefix);
//
//	List<PetDetails> findByNameEndingWith(String suffix);
	
	//positional parameter,order should match	
	@Query("select s from  PetDetails s where s.animalname=?1 and s.animalbreed=?2")
	     public List<PetDetails> getPetByname(String animalname,String animalbreed);
		
	
		//DML
		@Modifying
		@Query("delete from PetDetails s where s.animalname=?1")
		public int deletePetByname(String animalname);
		
		
		@Modifying
		@Query("update PetDetails s set s.animalbreed=?1 where s.animalname=?2")
		public int updatePetByname(String animalbreed,String animalname);
		
		@Query(value="select * from PetDetails s where s.animalname=?",nativeQuery=true)
		public List<PetDetails> fetchPetByname(String animalname);
		
	//named parameter
	@Query("select s from  PetDetails s where s.animalname=?1 and s.animalbreed=?2")
	 public List<PetDetails> getpetbyname(String animalname,String animalbreed);

}
