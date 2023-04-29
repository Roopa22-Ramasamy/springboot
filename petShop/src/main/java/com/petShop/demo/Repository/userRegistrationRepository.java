package com.petShop.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petShop.demo.Model.Registration;

@Repository
public interface userRegistrationRepository extends JpaRepository<Registration,Integer>
{

}
