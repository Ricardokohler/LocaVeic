package com.locaveics.locaveics.repositories;

import com.locaveics.locaveics.entities.Client;
import com.locaveics.locaveics.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

}
