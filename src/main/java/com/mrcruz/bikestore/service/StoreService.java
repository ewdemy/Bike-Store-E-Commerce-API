package com.mrcruz.bikestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.model.Store;
import com.mrcruz.bikestore.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	public Store create(Store store) {
		return storeRepository.save(store);
	}
	
	public void delete(Long id) {
		storeRepository.deleteById(id);
	}

}
