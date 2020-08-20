package com.mrcruz.bikestore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id", length = 4)
	private Long id;
	
	@Column(name="product_name", length = 255)
	@NotNull
	private String name;
	
	
	@NotNull
	@Length(max = 4)
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	
	@NotNull
	@Length(max = 4)
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name="model_year", length = 2)
	@NotNull
	private int modelYear;
	
	@NotNull
	@Column(name="list_price")
	@Digits(integer=10, fraction=2)
	private BigDecimal listPrice;
	
	
	
	
	
	
	
}
