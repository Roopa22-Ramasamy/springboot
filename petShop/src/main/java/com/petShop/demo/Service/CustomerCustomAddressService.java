package com.petShop.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petShop.demo.Model.Customer;
import com.petShop.demo.Repository.CustomerRepository;

@Service
public class CustomerCustomAddressService {

	@Autowired
	CustomerRepository customRep;
	
	public List<Customer> fetchAllCustomer() 
	{
		return customRep.findAll();
	}

	public Customer saveCustomer(Customer c) 
	{
		
		return customRep.save(c);
	}

}
