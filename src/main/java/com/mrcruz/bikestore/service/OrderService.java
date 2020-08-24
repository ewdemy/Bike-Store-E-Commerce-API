package com.mrcruz.bikestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.model.Order;
import com.mrcruz.bikestore.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order create(Order order) {
		return orderRepository.save(order);
	}
	
	public void delete(Long id) {
		orderRepository.deleteById(id);
	}

}
