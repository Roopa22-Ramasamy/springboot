package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
       @PutMapping(value="/updateStudent")
       public Student updateStudent(@RequestBody Student s)
       {
    	   return studService.saveStudent(s);
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
       
}
