package com.vehicle.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.rental.entity.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity,String>{

}
