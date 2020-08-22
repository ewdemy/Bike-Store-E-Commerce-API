package com.mrcruz.bikestore.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="stocks")
public class Stock {
	
	@EmbeddedId
	private StockId id;
	
	@MapsId("store")
	@NotNull
	@ManyToOne
	@JoinColumn(name="store_id", insertable = false, updatable = false)
	private Store store;
	
	@MapsId("product")
	@NotNull
	@ManyToOne
	@JoinColumn(name="product_id", insertable = false, updatable = false)
	private Product product;
	
	@Column(name = "quantity", nullable = true)
	private int quantity;
	
	
	
	

}
