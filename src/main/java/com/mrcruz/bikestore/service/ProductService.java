package com.mrcruz.bikestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.exception.BusinessException;
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
		
		if(!brandRepository.existsById(product.getBrand().getId()) || !categoryRepository.existsById(product.getCategory().getId())) {
			throw new BusinessException("Brand or category does not exist!");
		}
		
		
		return productRepository.save(product);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
