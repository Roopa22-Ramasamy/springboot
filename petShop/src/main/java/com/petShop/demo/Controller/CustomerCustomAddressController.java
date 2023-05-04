package com.petShop.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petShop.demo.Model.Customer;
import com.petShop.demo.Service.CustomerCustomAddressService;



@RestController
public class CustomerCustomAddressController 
{
       @Autowired
       CustomerCustomAddressService customerService;
       @GetMapping("/getAllCustomer")
       public List<Customer> fetchAllCustomer()
       {
    	  return customerService.fetchAllCustomer();
       }
       
       @PostMapping("/saveAlldata")
       public Customer saveCustomer(@RequestBody Customer c)
       {
    	   return customerService.saveCustomer(c);
       }
}
