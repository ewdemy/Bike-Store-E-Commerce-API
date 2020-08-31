package com.mrcruz.bikestore.service;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.model.Brand;
import com.mrcruz.bikestore.model.Customer;
import com.mrcruz.bikestore.model.Order;
import com.mrcruz.bikestore.model.Product;
import com.mrcruz.bikestore.model.Store;
import com.mrcruz.bikestore.repository.BrandRepository;
import com.mrcruz.bikestore.repository.CustomerRepository;
import com.mrcruz.bikestore.repository.OrderItemRepository;
import com.mrcruz.bikestore.repository.OrderRepository;
import com.mrcruz.bikestore.repository.ProductRepository;
import com.mrcruz.bikestore.repository.StoreRepository;

@Service
public class ReportService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	BrandRepository brandRepository;
	
	
	
	public List<Product> getPopularProduct() {
		List<Product> products = new ArrayList<Product>();
		
		List<Number> items = orderItemRepository.findItem();

		for(Number i: items) {
			Product p = productRepository.findById(i.intValue()).get();
			products.add(p);
			
		}
		
			return products;

	} 
	
	public Brand getBrandMoreProducts() {
		Long branId = (Long) productRepository.findBrand().longValue();
		Brand brand = brandRepository.findById(branId).get();
		
		
			return brand;

	} 
	
	public List<Customer> getCustomerMoreOrders() {
		List<Customer> customers = new ArrayList<Customer>();
		
		List<Number> items = orderRepository.findCustomers();

		for(Number i: items) {
			Customer c = customerRepository.findById(i.longValue()).get();
			customers.add(c);
			
		}
		
			return customers;

	} 
	
	public List<Store>  getStoresByCity(Long idCustomer){
		Customer customer = customerRepository.findById(idCustomer).get();
		return storeRepository.findByCity(customer.getCity());	
	}
	
	public List<Order>  getOrdersByCustomer(Long idCustomer){
		Customer customer = customerRepository.findById(idCustomer).get();
		return orderRepository.findByCustomer(customer);	
	}
	
	public List<Order>  getOrdersByDate(OffsetDateTime startDate, OffsetDateTime endDate){

		return orderRepository.findAllByDateGreaterThanEqualAndDateLessThanEqual(startDate, endDate);
	}
	
	

}
