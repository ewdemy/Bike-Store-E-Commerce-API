package com.mrcruz.bikestore.service;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;

import com.mrcruz.bikestore.model.Brand;
import com.mrcruz.bikestore.model.OrderItem;
import com.mrcruz.bikestore.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PopularProductDTO{
	
	
	private Long product_id;
	
	private Long qnt;

}
