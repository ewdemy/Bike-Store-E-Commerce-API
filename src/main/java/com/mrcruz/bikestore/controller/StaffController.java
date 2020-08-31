package com.mrcruz.bikestore.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mrcruz.bikestore.exception.BusinessException;
import com.mrcruz.bikestore.model.Staff;
import com.mrcruz.bikestore.repository.StaffRepository;
import com.mrcruz.bikestore.service.StaffService;

@RestController
@RequestMapping("/api/staffs")
public class StaffController {

	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	StaffService staffService;
	
	@GetMapping
	public List<Staff> getStaffs(){
		return staffRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Staff> getStaff(@PathVariable(value="id") Long id){
		Optional<Staff> staff = staffRepository.findById(id);
		if(staff.isPresent()) {
			return ResponseEntity.ok(staff.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Staff createStaff(@Valid @RequestBody Staff staff) {
		
		Staff staffExists = staffRepository.findByEmail(staff.getEmail());
		
		if(staffExists != null && !staffExists.equals(staff)) {
			throw new BusinessException("There is already an employee registered with this email!");
		}
		
		return staffService.create(staff);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Staff> updateStaff(@PathVariable(value="id") Long id, @Valid @RequestBody Staff staff){
		if(!staffRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		staff.setId(id);
		staff = staffService.create(staff);
		return ResponseEntity.ok(staff);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteStaff(@PathVariable(value="id") Long id) {
		if(!staffRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		staffService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
