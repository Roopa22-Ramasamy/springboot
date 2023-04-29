package com.petShop.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petShop.demo.Model.User;

@Repository
public interface userRepository extends JpaRepository<User,Integer>
{
      User findByuname(String uname);  
}
