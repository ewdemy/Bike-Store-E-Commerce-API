package com.mrcruz.bikestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrcruz.bikestore.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}