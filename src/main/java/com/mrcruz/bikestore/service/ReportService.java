package com.mrcruz.bikestore.service;


import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.model.OrderItem;
import com.mrcruz.bikestore.model.Product;
import com.mrcruz.bikestore.repository.OrderItemRepository;
import com.mrcruz.bikestore.repository.ProductRepository;

@Service
public class ReportService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	@Autowired
	EntityManager manager;
	
	public List<Product> getPopularProduct() {
		List<Product> products = new ArrayList<Product>();
		
		List<Number> items = orderItemRepository.findItem();
		//Long item = items.get(0).longValue();
		
	
		for(Number i: items) {
			Product p = productRepository.findById(i.longValue()).get();
			products.add(p);
			
		}
		
			return products;

	} 
	
	

}
