package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository

public interface StudentRepository extends JpaRepository<Student,Integer> 
{
	//positional parameter,order should match
	@Query("select s from Student s where s.dept=?1 and s.name=?2")
     public List<Student> getStudentsByDept(String dept,String name);
	
	//named parameter
	@Query("select s from Student s where s.dept=:dept")
    public List<Student> getStudentsByDept(String dept);
	
	//DML
	@Modifying
	@Query("delete from Student s where s.name=?1")
	public int deleteStudentByName(String name);
	
	 List<Student> findByNameStartingWith(String prefix);
	 List<Student> findByNameEndingWith(String suffix);
	 List<Student> findByDept(String dept);

}
