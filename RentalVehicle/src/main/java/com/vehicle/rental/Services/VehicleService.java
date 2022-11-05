package com.vehicle.rental.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.rental.entity.VehicleEntity;
import com.vehicle.rental.models.Vehicle;
import com.vehicle.rental.repository.VehicleRepository;




@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> getAllVehicles(){
		List<VehicleEntity> vehicleEntities = vehicleRepository.findAll();
		List<Vehicle> allVehicles = vehicleEntities.stream().map(veh -> new Vehicle(veh.getId(),
																				veh.getBrand(),
																				veh.getName(),
																				veh.getColor(),
																				veh.getPrice(),
																				veh.isAutomatic(),
																				veh.getMileage()))
																				.collect(Collectors.toList());
		return allVehicles;
	}
	
	public Vehicle getVehicleById(String id) {
		Optional<VehicleEntity> optional = vehicleRepository.findById(id);
		VehicleEntity veh = optional.get();
		Vehicle vehilce = new Vehicle(veh.getId(),
				veh.getBrand(),
				veh.getName(),
				veh.getColor(),
				veh.getPrice(),
				veh.isAutomatic(),
				veh.getMileage());
		
		return vehilce;
		
	}
	
	public void createVehicle(Vehicle veh) {
		VehicleEntity vehiclEntity = new VehicleEntity(veh.getId(),
				veh.getBrand(),
				veh.getName(),
				veh.getColor(),
				veh.getPrice(),
				veh.isAutomatic(),
				veh.getMileage());
		vehicleRepository.save(vehiclEntity);
		
	}
	
	public void removeVehiclebyId(String id) {
		Optional<VehicleEntity> optional = vehicleRepository.findById(id);
		VehicleEntity veh = optional.get();
		vehicleRepository.delete(veh);
		
//		vehicleRepository.deleteById(id);
	}
	
	public void updateVehiclesPrice(String id,long price) {
		Optional<VehicleEntity> optional = vehicleRepository.findById(id);
		VehicleEntity veh = optional.get();
		veh.setPrice(price);
		vehicleRepository.save(veh);
	}

}
