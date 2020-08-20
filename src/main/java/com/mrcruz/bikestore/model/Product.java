package com.mrcruz.bikestore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	@Size(max = 4)
	private Long id;
	
	@Column(name="product_name")
	@NotBlank
	@Size(max = 255)
	private String name;
	
	@Column(name="brand_id")
	@NotBlank
	@Size(max = 4)
	@OneToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@Column(name="category_id")
	@NotBlank
	@Size(max = 4)
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name="model_year")
	@NotBlank
	@Size(max = 2)
	private int modelYear;
	
	@Column(name="list_price")
	@Digits(integer=10, fraction=2)
	private BigDecimal listPrice;
	
	
	
	public Product() {
		}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	public BigDecimal getListPrice() {
		return listPrice;
	}
	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
