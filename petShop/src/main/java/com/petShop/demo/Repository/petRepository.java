package com.petShop.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petShop.demo.Model.Pet;


@Repository
public interface petRepository extends JpaRepository<Pet,Integer>
{
	
}
