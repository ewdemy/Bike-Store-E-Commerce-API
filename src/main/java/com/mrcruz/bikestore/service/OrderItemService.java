package com.mrcruz.bikestore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.model.Order;
import com.mrcruz.bikestore.model.OrderItem;
import com.mrcruz.bikestore.model.OrderItemId;
import com.mrcruz.bikestore.model.Product;
import com.mrcruz.bikestore.repository.OrderItemRepository;
import com.mrcruz.bikestore.repository.OrderRepository;
import com.mrcruz.bikestore.repository.ProductRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public OrderItem create(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}
	
	public void delete(OrderItemId id) {
		orderItemRepository.deleteById(id);
	}

}
