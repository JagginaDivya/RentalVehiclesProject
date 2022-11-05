package com.vehicle.rental.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.rental.Services.VehicleService;
import com.vehicle.rental.models.Vehicle;

@RestController
@RequestMapping("/api/v1/")
public class VehicleController {

	@Autowired
	private VehicleService vehilceService;
	
	@GetMapping("/getAllVehicles")
	public List<Vehicle> getAllVehicles(){
		List<Vehicle> allVehicles = vehilceService.getAllVehicles();
		return allVehicles;
		
	}
	
	@PostMapping("/createVehicle")
	public ResponseEntity<String> createVehicle(@RequestBody Vehicle vehicle) {
		if(vehicle!=null) {
			vehilceService.createVehicle(vehicle);
			return ResponseEntity.ok("Vehicle Created SuccesFully");
		}
		return ResponseEntity.badRequest().body("Vehicle Creation Failed!!");
		
	}
	
	@GetMapping("/vehicles/vehicle/{id}")
	public Vehicle getVehicleById(@PathVariable String id) {
		Vehicle veh = vehilceService.getVehicleById(id);
		return veh;
	}
	
	@PutMapping("/vehicles/vehicle")
	public ResponseEntity<String> updateVehicleById(@RequestParam String id, @RequestParam long price) {
		vehilceService.updateVehiclesPrice(id,price);
		System.out.println("Updated SuccesFully");
		return ResponseEntity.badRequest().body("Vehicle Updation SuccesFull!!");
	}
	
	@DeleteMapping("/vehicles/vehicle/{id}")
	public ResponseEntity<String> deleteVehicleById(@PathVariable String id) {
		vehilceService.removeVehiclebyId(id);
		System.out.println("Removed SuccesFully");
		return ResponseEntity.badRequest().body("Vehicle deletion SuccesFull!!");
	}
}
