package com.mrcruz.bikestore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
	@SequenceGenerator(allocationSize=0, name="prod_seq", sequenceName = "osf.products_seq")
	@Column(name="product_id")
	private Long id;
	
	@Column(name="product_name")
	@NotBlank
	@Size
	private String name;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@NotNull
	@Column(name="model_year")
	private int modelYear;
	
	@NotNull
	@Column(name="list_price")
	@Digits(integer=10, fraction=2)
	private BigDecimal listPrice;
	
	
	
	
	
	
	
}
