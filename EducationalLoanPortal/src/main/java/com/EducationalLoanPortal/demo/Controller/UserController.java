package com.EducationalLoanPortal.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EducationalLoanPortal.demo.Model.LoanApplicationModel;
import com.EducationalLoanPortal.demo.Model.LoginModel;
import com.EducationalLoanPortal.demo.Model.UserModel;
import com.EducationalLoanPortal.demo.Service.LoanApplicationModelService;
import com.EducationalLoanPortal.demo.Service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController 
{
	@Autowired
	UserService uSer;
	@Autowired
	LoanApplicationModelService lamService;
	 @GetMapping("/fetch")
     public List<UserModel> getUserDetails()
     {
  	   List<UserModel> userList = uSer.getUserDetails();
  	   return userList;
     }
	@PostMapping("/userlogin")
	public String validateUser(@RequestBody LoginModel logindata )
	{
		
		return uSer.validateUser(logindata.getEmail(),logindata.getPassword());
		
	}
	@PostMapping("/usersignup")
	public UserModel newUser(@RequestBody UserModel user)
	{
		return uSer.newUser(user);
	}
	@GetMapping(value="/getloan/{loanId}")
    public  LoanApplicationModel getLoan(@PathVariable int loanId)
    {
    	return uSer.getLoan(loanId);
    }
	@GetMapping("/getprofile/{id}")
	public UserModel getProfile(@PathVariable int id)
	{
		return uSer.getProfile(id);
	}
	@PutMapping(value="/updateUser/{id}")  //update
    public  UserModel updateUser(@RequestBody UserModel u,@PathVariable int id)
    {
    	
    	return uSer.updateUser(u,id);
    	
    }
	@DeleteMapping(value="/deleteUser/{id}")
    public void deleteUser(@PathVariable int id)
    {
 	   uSer.deleteUser(id);
    } 
	@PostMapping("/postuser")
	public UserModel addUser(@RequestBody UserModel u)
	{
		return uSer.addUser(u) ;
	}
	
	
    

}
