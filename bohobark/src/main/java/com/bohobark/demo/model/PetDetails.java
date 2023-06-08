package com.bohobark.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PetDetails 
{
          @Id
          private int animalcode;
          private String animalname;
          private String animalbreed;
          private String color;
          private int age;
          private int price;
          private int weight;
          private int height;
          private String characteristics;
		public int getAnimalcode() {
			return animalcode;
		}
		public void setAnimalcode(int animalcode) {
			this.animalcode = animalcode;
		}
		public String getAnimalname() {
			return animalname;
		}
		public void setAnimalname(String animalname) {
			this.animalname = animalname;
		}
		public String getAnimalbreed() {
			return animalbreed;
		}
		public void setAnimalbreed(String animalbreed) {
			this.animalbreed = animalbreed;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public String getCharacteristics() {
			return characteristics;
		}
		public void setCharacteristics(String characteristics) {
			this.characteristics = characteristics;
		}
         
      
}