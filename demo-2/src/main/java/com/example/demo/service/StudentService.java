package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService
{
       @Autowired
       StudentRepository studRepository;
       
       public List<Student> getAllStudent()
       {
    	  List<Student> studList = studRepository.findAll();
    	  return studList;
       }
       public Student saveStudent(Student s)
       {
    	  Student obj = studRepository.save(s);
          return obj;
          // return studRepository.save(s);
       }
       public  Student updateStudent(Student s,int rno) 
       {
   		Optional<Student> optional=studRepository.findById(rno);
   		Student obj=null;
   		if(optional.isPresent())
   		{
   			obj=optional.get();
   			/*obj.setRegno(s.getRegno());
   			obj.setName(s.getName());
   			obj.setDept(s.getDept());
   			obj.setEmail(s.getEmail());*/
   		studRepository.save(s);
   		}
   		return obj;
   	
   		
   	}
       public void deleteStudent(int regno)
       {
    	   studRepository.deleteById(regno);
          
       }
       public Student getStudent(int regno)
       {
    	   Student s = studRepository.findById(regno).get();
    	   return s;
       }
       public List<Student> sortStudents(String field)
       {
    	   //return studRepository.findAll(Sort.by(field)); //ascending
    	   return studRepository.findAll(Sort.by(Direction.DESC,field));  //descending
       }
	public List<Student> pagingStudents(int offset, int pagesize) 
	{
		PageRequest paging = PageRequest.of(offset,pagesize);
		Page<Student> studData = studRepository.findAll(paging);
		List<Student> studList = studData.getContent();
		return studList;
	}
	public List<Student> pagingAndSortingStudents(int offset,int pageSize,String field)
	{
		PageRequest paging = PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<Student> stud = studRepository.findAll(paging);
		return stud.getContent();
	}
	public List<Student> fetchStudentsByNamePrefix(String prefix)
	{
		return studRepository.findByNameStartingWith(prefix);
		
	}
	public List<Student> fetchStudentsByNameSuffix(String suffix)
	{
		return studRepository.findByNameEndingWith(suffix);
		
	}
	public List<Student> fetchStudentsByNameDepartment(String dept)
	{
		return studRepository.findByDept(dept);
	}
	public List<Student> getStudentsByDept(String dept,String name)
	  {
		  return studRepository.getStudentsByDept(dept, name);
	  }
	@Transactional 
	public int deleteStudentByName(String name)
	{
		return studRepository.deleteStudentByName(name);
	}
	@Transactional
	public int updateStudentByName(String dept,String name)
	{
		return studRepository.updateStudentByName(dept, name);
	}
	public List<Student> fetchStudentByDept(String dept)
	{
		return studRepository.fetchStudentByDept(dept);
	}
       
}
