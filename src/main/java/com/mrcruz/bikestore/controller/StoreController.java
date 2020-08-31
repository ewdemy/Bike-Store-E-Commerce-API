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

import com.mrcruz.bikestore.model.Store;
import com.mrcruz.bikestore.repository.StoreRepository;
import com.mrcruz.bikestore.service.StoreService;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping
	public List<Store> getStores(){
		return storeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Store> getStore(@PathVariable(value="id") Long id){
		Optional<Store> store = storeRepository.findById(id);
		if(store.isPresent()) {
			return ResponseEntity.ok(store.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Store createStore(@Valid @RequestBody Store store) {
		return storeService.create(store);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Store> updateStore(@PathVariable(value="id") Long id, @Valid @RequestBody Store store){
		if(!storeRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		store.setId(id);
		store = storeService.create(store);
		
		return ResponseEntity.ok(store);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteStore(@PathVariable(value="id") Long id) {
		if(!storeRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		storeService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
