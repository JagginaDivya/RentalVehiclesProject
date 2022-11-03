package com.vehicle.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RentalVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalVehicleApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String Hello() {
		return "hello";
	}
	
	@GetMapping("/bye")
	public String Bye() {
		return "Bye";
	}
	
	@GetMapping("/morning")
	public String Morning() {
		return "Morning";
	}
	
}
