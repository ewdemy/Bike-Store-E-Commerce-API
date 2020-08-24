package com.mrcruz.bikestore.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
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
@Table(name="order_items")
@IdClass(OrderItemId.class)
public class OrderItem {
	

	
	
	@Id
	@NotNull
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	
	@Column(name = "item_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@NotNull
	private int quantity;
	
	@NotNull
	@Column(name = "list_price")
	@Digits(integer=10, fraction=2)
	private BigDecimal listPrice;
	
	@NotNull
	@Digits(integer=4, fraction=2)
	private BigDecimal discount;
	

	
	
}
