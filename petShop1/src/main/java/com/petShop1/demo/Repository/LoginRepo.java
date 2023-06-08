package com.petShop1.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petShop1.demo.Model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login,Integer>
{

}
