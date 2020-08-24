package com.mrcruz.bikestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.model.OrderItem;
import com.mrcruz.bikestore.model.OrderItemId;
import com.mrcruz.bikestore.repository.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public OrderItem create(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}
	
	public void delete(OrderItemId id) {
		orderItemRepository.deleteById(id);
	}

}
