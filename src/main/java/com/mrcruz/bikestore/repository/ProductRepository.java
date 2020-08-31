package com.mrcruz.bikestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrcruz.bikestore.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value = "select brand_id, count(product_id) as qnt "
			+ "from osf.products group by brand_id  order by qnt desc limit 1;", nativeQuery = true)
	Number findBrand();
}
