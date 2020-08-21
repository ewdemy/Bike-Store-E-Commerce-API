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
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long id;
	
	@Column(name="first_name")
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	private String lastName;
	
	private String phone;
	
	@NotNull
	private String email;
	
	private String street;
	private String city;
	private String state;
	
	@Column(name="zip_code")
	private String zipCode;
	
	

}
