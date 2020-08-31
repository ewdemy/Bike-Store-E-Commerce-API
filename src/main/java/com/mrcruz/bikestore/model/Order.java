package com.mrcruz.bikestore.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ord_seq")
	@SequenceGenerator(allocationSize=0, name="ord_seq", sequenceName = "osf.orders_seq")
	@Column(name = "order_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = true)
	private Customer customer;
	
	
	@Column(name = "order_status")
	@NotNull
	private int status;
	
	@Column(name = "order_date")
	@NotNull
	private OffsetDateTime date;
	
	@Column(name = "required_date")
	@NotNull
	private OffsetDateTime requiredDate;
	
	@Column(name = "shipped_date")
	private OffsetDateTime shippedDate;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	

	
	
	
}
