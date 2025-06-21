package com.locaveics.locaveics.repositories;

import com.locaveics.locaveics.entities.Client;
import com.locaveics.locaveics.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
