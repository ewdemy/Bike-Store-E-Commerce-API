package com.mrcruz.bikestore.model;

import com.mrcruz.bikestore.service.PopularProductDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
	
	private Order order;
	private OrderItem item;
	

}
