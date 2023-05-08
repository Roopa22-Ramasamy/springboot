package com.EducationalLoanPortal.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EducationalLoanPortal.demo.Model.LoanApplicationModel;
//import com.EducationalLoanPortal.demo.Model.UserModel;
import com.EducationalLoanPortal.demo.Service.LoanApplicationModelService;

@RestController
public class LoanApplicationModelController 
{
  @Autowired
  LoanApplicationModelService lamService;
  @GetMapping("/fetchloan")
  public List<LoanApplicationModel> fetchLoan()
  {
	  List<LoanApplicationModel> loanlist = lamService.fetchLoan();
			  return loanlist;
  }
	@PutMapping(value="/updateLoan/{loanId}") //update
    public  LoanApplicationModel updateLoan(@RequestBody LoanApplicationModel l,@PathVariable int loanId)
    {
    	
    	return lamService.updateLoan(l,loanId);
    	
    }
	@DeleteMapping(value="/deleteLoan/{loanId}")
    public void deleteLoan(@PathVariable int loanId)
    {
		lamService.deleteLoan(loanId);
    }
	@PostMapping("/addLoan")
	public LoanApplicationModel saveLoan(@RequestBody LoanApplicationModel m)
	{
		return lamService.saveLoan(m);
	}
  
}
