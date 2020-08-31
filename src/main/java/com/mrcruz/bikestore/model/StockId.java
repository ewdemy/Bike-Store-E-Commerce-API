package com.mrcruz.bikestore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StockId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "store_id")
	private Long store;
	@Column(name = "product_id")
	private Long product;
	

}
