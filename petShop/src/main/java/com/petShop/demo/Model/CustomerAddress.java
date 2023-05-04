package com.petShop.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="custom")
public class CustomerAddress 
{
    @Id
    @GeneratedValue
    private int id;
    private String street;
    private String city;
    private String pinCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return String.format("CustomerAddress [id=%s, street=%s, city=%s, pinCode=%s]", id, street, city, pinCode);
	}
}
