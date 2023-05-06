package com.petShop.demo.Model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer 
{
       @Id
       @GeneratedValue    //child class
       private int id;
       private String customerName;
       private String customerEmail;
       private int customerPhoneNumber;
       @OneToOne(cascade=CascadeType.ALL)
     // @JoinColumn(name = "customer_Id" )`
       private CustomerAddress customAddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public int getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(int customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public CustomerAddress getCustomAddress() {
		return customAddress;
	}
	public void setCustomAddress(CustomerAddress customAddress) {
		this.customAddress = customAddress;
	}
	@Override
	public String toString() {
		return String.format(
				"Customer [id=%s, customerName=%s, customerEmail=%s, customerPhoneNumber=%s, customAddress=%s]", id,
				customerName, customerEmail, customerPhoneNumber, customAddress);
	}
	
       
}
