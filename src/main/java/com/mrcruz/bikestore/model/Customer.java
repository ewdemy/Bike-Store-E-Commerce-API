package com.mrcruz.bikestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
	@SequenceGenerator(allocationSize=0, name="cust_seq", sequenceName = "osf.customers_seq")
	@Column(name="customer_id")
	private Long id;
	
	@Column(name="first_name")
	@NotBlank
	@Size
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank
	@Size
	private String lastName;
	
	@Size(max = 25)
	private String phone;
	
	@NotBlank
	@Size
	@Email
	private String email;
	
	@Size
	private String street;
	
	@Size(max = 50)
	private String city;
	
	@Size(max = 25)
	private String state;
	
	@Column(name="zip_code")
	@Size(max = 5)
	private String zipCode;
	
	

}
