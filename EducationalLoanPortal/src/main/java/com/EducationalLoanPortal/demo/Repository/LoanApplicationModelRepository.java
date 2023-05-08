package com.EducationalLoanPortal.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EducationalLoanPortal.demo.Model.LoanApplicationModel;

@Repository
public interface LoanApplicationModelRepository extends JpaRepository<LoanApplicationModel,Integer>
{

}
