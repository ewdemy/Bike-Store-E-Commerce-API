package com.mrcruz.bikestore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mrcruz.bikestore.model.OrderItem;
import com.mrcruz.bikestore.model.OrderItemId;
import com.mrcruz.bikestore.repository.OrderItemRepository;
import com.mrcruz.bikestore.service.OrderItemService;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderItemService orderItemService;
	
	
	@GetMapping
	public List<OrderItem> getOrderItems(){
		return orderItemRepository.findAll();
	}
	
	@GetMapping("/{orderId}/{itemId}")
	public ResponseEntity<OrderItem> getOrdemItem(@PathVariable(value="orderId") Long orderId, @PathVariable(value="itemId") Long itemId){
		OrderItemId id = new OrderItemId(orderId,itemId);
		Optional<OrderItem> orderItem = orderItemRepository.findById(id);
		
		if(orderItem.isPresent()) {
			return ResponseEntity.ok(orderItem.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
		return orderItemService.create(orderItem);
	
	}
	
	@PutMapping("/{orderId}/{itemId}")
	public ResponseEntity<OrderItem> updateOrderItem(
			@PathVariable(value="orderId") Long orderId, 
			@PathVariable(value="itemId") Long itemId, 
			@RequestBody OrderItem orderItem ){
		OrderItemId id = new OrderItemId(orderId,itemId);
		if(!orderItemRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		orderItem = orderItemService.create(orderItem);
		return ResponseEntity.ok(orderItem);
	}
	
	@DeleteMapping("/{orderId}/{itemId}")
	public ResponseEntity deleteOrderItem(
			@PathVariable(value="orderId") Long orderId, 
			@PathVariable(value="itemId") Long itemId ){
		OrderItemId id = new OrderItemId(orderId,itemId);
		if(!orderItemRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		orderItemService.delete(id);
		return ResponseEntity.noContent().build();
	}
	}
