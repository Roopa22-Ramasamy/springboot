package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController 
{
       @Autowired
       StudentService studService;
       @GetMapping("/fetch")
       public List<Student> getAllStudents()
       {
    	   List<Student> studList = studService.getAllStudent();
    	   return studList;
       }
     //http://localhost:8080/saveStudent
       @PostMapping(value="/saveStudent")
       public Student saveStudent(@RequestBody Student s)
       {
    	   return studService.saveStudent(s);
       }
       @PutMapping(value="/updateStudent/{rno}")
       public  Student updateStudent(@RequestBody Student s,@PathVariable int rno)
       {
       	
       	return studService.updateStudent(s,rno);
       	
       	
       }
       @DeleteMapping(value="/deleteStudent/{rno}")
       public void deleteStudent(@PathVariable("rno") int regno)
       {
    	   studService.deleteStudent(regno);
       } 
       @GetMapping(value="/getStudent/{rno}")
       public Student getStudent(@PathVariable("rno")  int regno)
       {
       	return studService.getStudent(regno);
       }
       
       @GetMapping("/sortStudent/{field}")
       public List<Student> sortStudents(@PathVariable String field  )
       {
    	   return studService.sortStudents(field);
       }
       @GetMapping("/pagingStudents/{offset}/{pagesize}")
        public List<Student> pagingStudents(@PathVariable int offset,@PathVariable int pagesize)
       {
    	   return studService.pagingStudents(offset,pagesize);
       }
       @GetMapping("/pagingAndSortingStudent/{offset}/{pagesize}/{field}")
       public List<Student> pagingAndSortingStudents(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
       {
    	   return studService.pagingAndSortingStudents(offset,pagesize,field);
       }
       @GetMapping("/fetchStudentsByNamePrefix")
       public List<Student> fetchStudentsByNamePrefix(@RequestParam String prefix)
   	    {
   		return studService.fetchStudentsByNamePrefix(prefix);
   		
   	    }
       @GetMapping("/fetchStudentsByNameSuffix")
       public List<Student> fetchStudentsByNameSuffix(@RequestParam String suffix)
       {
    	   return studService.fetchStudentsByNameSuffix(suffix);
       }
       @GetMapping("/fetchStudentsByNameDepartment")
       public List<Student> fetchStudentsByNameDepartment(@RequestParam String dept)
       {
    	   return studService.fetchStudentsByNameDepartment(dept);
    	   
       }
       @GetMapping("/fetchStudentsByDept/{dept}/{name}")
       public List<Student> fetchStudentsByDept(@PathVariable String dept,@PathVariable String name)
       {
    	   return studService.getStudentsByDept(dept,name);
       }
       @DeleteMapping("/deleteStudentByName/{name}")
       public String deleteStudentByName(@PathVariable String name)
       {
    	   int result = studService.deleteStudentByName(name);
    	   if(result>0)
    		     return "Student record deleted";
    	   else
    		     return "Problem occured while deleting";
    		     	
       }
      @PutMapping("/updateStudent/{dept}/{name}")
       public int updateStudentByName(@PathVariable String dept,@PathVariable String name)
       {
    	   return studService.updateStudentByName(dept, name);
    	  
       }
      @GetMapping("/fetchStudentByDept/{dept}")
      public List<Student> fetchStudentByDept(@PathVariable String dept)
      {
    	  return studService.fetchStudentByDept(dept);
      }
       
}
