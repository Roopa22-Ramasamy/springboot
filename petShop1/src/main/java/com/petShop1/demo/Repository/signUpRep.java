package com.petShop1.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petShop1.demo.Model.Signup;

public interface signUpRep extends JpaRepository<Signup, Integer>
{

}
