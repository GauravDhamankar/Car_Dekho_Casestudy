package com.jspiders.cardekhocasestudy.entity;

public class Car {

    private int id;
    private String name;
    private String brand ;
    private double price;
    private String fuelType;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", fuelType=" + fuelType
				+ "]";
	}
	
	
    
    

}
