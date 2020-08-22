package com.mrcruz.bikestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrcruz.bikestore.model.Stock;
import com.mrcruz.bikestore.model.StockId;


@Repository
public interface StockRepository extends JpaRepository<Stock, StockId> {
	//Stock existsById(StockId stockId);

}
