package com.petShop1.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petShop1.demo.Model.PetShop1;
@Repository
public interface petShop1Repo extends JpaRepository<PetShop1,Integer>
{

}
