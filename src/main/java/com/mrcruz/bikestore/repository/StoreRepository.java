package com.mrcruz.bikestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrcruz.bikestore.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	
	public List<Store> findByCity(String city);
	
}
