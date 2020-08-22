package com.mrcruz.bikestore.controller;

import java.util.List;
import java.util.Optional;

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

import com.mrcruz.bikestore.model.Product;
import com.mrcruz.bikestore.repository.ProductRepository;
import com.mrcruz.bikestore.service.ProductService;

@RestController
@RequestMapping("/api/bikes")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(value="id") Long id){
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return ResponseEntity.ok(product.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		return productService.create(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value="id") Long id, @RequestBody Product product){
		if(!productRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		product.setId(id);
		product = productService.create(product);
		
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable(value="id") Long id) {
		if(!productRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	

}
