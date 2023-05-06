package com.portalproblem.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portalproblem.demo.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
  
}
