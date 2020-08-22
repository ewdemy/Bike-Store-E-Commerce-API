package com.mrcruz.bikestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="staffs")
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private Long id;
	
	@Column(name="first_name")
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	private String lastName;
	
	@Column(name="email",unique = true)
	@NotNull
	private String email;
	
	private String phone;
	
	@NotNull
	private int active;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	//@OneToMany
	//@JoinColumn(name = "manager_id", nullable = true)
	private Staff manager;
	

	
	
	

}
