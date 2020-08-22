package com.mrcruz.bikestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.model.Staff;
import com.mrcruz.bikestore.repository.StaffRepository;

@Service
public class StaffService {
	
	
	@Autowired
	StaffRepository staffRepository;
	
	public Staff create(Staff staff) {
		return staffRepository.save(staff);
	}
	
	public void delete(Long id) {
		staffRepository.deleteById(id);
	}
	

}
