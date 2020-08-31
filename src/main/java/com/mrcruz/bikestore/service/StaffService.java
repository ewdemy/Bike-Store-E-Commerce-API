package com.mrcruz.bikestore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.exception.BusinessException;
import com.mrcruz.bikestore.model.Staff;
import com.mrcruz.bikestore.repository.StaffRepository;


@Service
public class StaffService {
	
	
	@Autowired
	StaffRepository staffRepository;
	
	public Staff create(Staff staff) {
		
		if(staff.getManager() != null) {
			Optional<Staff> manager = staffRepository.findById(staff.getManager().getId());
			if(!manager.isPresent()) {
				throw new BusinessException("Manager does not exist!");
			}
			
			if(manager.get().getManager().getId() == staff.getId()) {
				throw new BusinessException("Manager invalid!");
			}
		}
		
		
		return staffRepository.save(staff);
	}
	
	public void delete(Long id) {
		staffRepository.deleteById(id);
	}
	

}
