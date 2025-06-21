package com.locaveics.locaveics.repositories;

import com.locaveics.locaveics.entities.Client;
import com.locaveics.locaveics.entities.RentalAgent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalAgentRepository extends JpaRepository<RentalAgent,Long> {

}
