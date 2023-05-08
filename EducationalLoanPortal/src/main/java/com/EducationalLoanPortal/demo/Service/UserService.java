package com.EducationalLoanPortal.demo.Service;

import java.util.List;
import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EducationalLoanPortal.demo.Model.LoanApplicationModel;
import com.EducationalLoanPortal.demo.Model.UserModel;
import com.EducationalLoanPortal.demo.Repository.LoanApplicationModelRepository;
import com.EducationalLoanPortal.demo.Repository.UserRepository;





@Service
public class UserService 
{
    @Autowired
    UserRepository uRep;
    @Autowired
    LoanApplicationModelRepository lamRep;
	public String validateUser(String email,String password) 
	{
		
		UserModel u = uRep.findByEmail(email);
		if(u == null)
		{
			return" No user found " ;
		}
		else
		{
			if(u.getPassword().equals(password))
			{
				return"Login Successfull" ;
			}
			else
			{
				return "Login Failed" ;
			}
		}
	}
	
	

	public UserModel newUser(UserModel user) 
	{
		
		return uRep.save(user);
	}



	public List<UserModel> getUserDetails() 
	{
		
		return uRep.findAll();
	}



	 public LoanApplicationModel getLoan(int loanId)
     {
		 LoanApplicationModel l = lamRep.findById(loanId).get();
  	   return l;
     }



	public UserModel getProfile(int id) 
	{
		
		UserModel u = uRep.findById(id).get();
		return u;
	}



	public UserModel updateUser(UserModel u, int id) 
	{
		
		Optional<UserModel> optional= uRep.findById(id);
   		UserModel obj=null;
   		if(optional.isPresent())
   		{
   			obj=optional.get();
   		    uRep.save(u);
   		}
   		return obj;
	}



	public void deleteUser(int id) 
	{
		
		uRep.deleteById(id);
	}



	public UserModel addUser(UserModel u) {
		return uRep.save(u);
		
	}



	



	
	}
	
	

    

