package com.mrcruz.bikestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="stores")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private Long id;
	
	@Column(name = "store_name")
	@NotNull
	private String name;
	private String phone;
	private String email;
	private String street;
	private String city;
	private String state;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	
	
	

}
