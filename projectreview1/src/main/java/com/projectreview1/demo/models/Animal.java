package com.projectreview1.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Animal 
{
	@Id
	private int count;
    private String name;
    private String type;
    private String color;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
    
}
