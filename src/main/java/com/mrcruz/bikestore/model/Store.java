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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="stores")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sto_seq")
	@SequenceGenerator(allocationSize=0, name="sto_seq", sequenceName = "osf.stores_seq")
	@Column(name = "store_id")
	private Long id;
	
	@Column(name = "store_name")
	@NotBlank
	@Size
	private String name;
	
	@Size(max = 25)
	private String phone;
	
	@Email
	private String email;
	private String street;
	private String city;
	
	@Size(max = 10)
	private String state;
	
	@Column(name = "zip_code")
	@Size(max = 5)
	private String zipCode;
	
	
	
	

}
