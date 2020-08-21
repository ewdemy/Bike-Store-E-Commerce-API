package com.mrcruz.bikestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.model.Brand;
import com.mrcruz.bikestore.model.Category;
import com.mrcruz.bikestore.model.Product;
import com.mrcruz.bikestore.repository.BrandRepository;
import com.mrcruz.bikestore.repository.CategoryRepository;
import com.mrcruz.bikestore.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Product create(Product product) {
		
		Brand brand =  brandRepository.findById(product.getBrand().getId()).get();
		Category category =  categoryRepository.findById(product.getCategory().getId()).get();
		
		product.setBrand(brand);
		product.setCategory(category);
		
		return productRepository.save(product);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
