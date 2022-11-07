package com.vehicle.rental.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vehicle")
public class VehicleEntity {
	
	@Id
	private String id;
	private String brand;
	private String name;
	private String color;
	private long price;
	private boolean isAutomatic; // automatic or Manual
	private long mileage;
	
	
	

}
