package com.projectreview1.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectreview1.demo.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer>
{

}
