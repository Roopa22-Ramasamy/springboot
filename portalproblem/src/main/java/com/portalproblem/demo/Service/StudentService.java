package com.portalproblem.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.portalproblem.demo.Model.Student;
import com.portalproblem.demo.Repository.StudentRepository;

@Service
public class StudentService 
{
      @Autowired
      StudentRepository stuRepo;
      public List<Student> get(@PathVariable String StudentCourse)
      {
     	 return stuRepo.findAll();
      }
	public List<Student> getId(@PathVariable int studentCourseId) 
	{
		
		return stuRepo.findAll();
	}
      
}
