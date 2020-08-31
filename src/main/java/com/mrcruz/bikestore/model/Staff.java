package com.mrcruz.bikestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="staffs")
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_seq")
	@SequenceGenerator(allocationSize=0, name="staff_seq", sequenceName = "osf.staffs_seq")
	@Column(name = "staff_id")
	private Long id;
	
	@Column(name="first_name")
	@NotBlank
	@Size(max = 50)
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank
	@Size(max = 50)
	private String lastName;
	
	@Column(name="email",unique = true )
	@NotBlank
	@Size
	@Email
	private String email;
	
	@Size(max = 25)
	private String phone;
	
	@NotNull
	private int active;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@OneToOne
	@JoinColumn(name = "manager_id")
	private Staff manager;
	
	
	

	
	
	

}
