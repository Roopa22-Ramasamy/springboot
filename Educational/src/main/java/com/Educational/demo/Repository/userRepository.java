package com.Educational.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Educational.demo.Model.userModel;

@Repository
public interface userRepository extends JpaRepository<userModel,Integer>
{

}
