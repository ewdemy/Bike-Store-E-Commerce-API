package com.mrcruz.bikestore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrcruz.bikestore.model.Order;
import com.mrcruz.bikestore.repository.OrderRepository;
import com.mrcruz.bikestore.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Order> getOrder(@PathVariable(value="id") Long id){
		Optional<Order> order = orderRepository.findById(id);
		if(order.isPresent()) {
			return ResponseEntity.ok(order.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		return orderService.create(order);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value="id") Long id, @RequestBody Order order){
		if(!orderRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		order.setId(id);
		order = orderService.create(order);
		return ResponseEntity.ok(order);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteOrder(@PathVariable(value="id") Long id) {
		if(!orderRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		orderService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
