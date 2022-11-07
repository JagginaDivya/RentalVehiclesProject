package com.vehicle.rental.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
	
	
	private String id;
	private String brand;
	private String name;
	private String color;
	private long price;
	private boolean isAutomatic; // automatic or Manual
	private long mileage;
	
	}
