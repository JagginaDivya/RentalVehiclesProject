package com.vehicle.rental.models;




public class Vehicle {
	
	
	private String id;
	private String brand;
	private String name;
	private String color;
	private long price;
	private boolean isAutomatic; // automatic or Manual
	private long mileage;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String id, String brand, String name, String color, long price, boolean isAutomatic, long mileage) {
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.color = color;
		this.price = price;
		this.isAutomatic = isAutomatic;
		this.mileage = mileage;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public boolean isAutomatic() {
		return isAutomatic;
	}
	public void setAutomatic(boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}
	public long getMileage() {
		return mileage;
	}
	public void setMileage(long mileage) {
		this.mileage = mileage;
	}
	
	

}
