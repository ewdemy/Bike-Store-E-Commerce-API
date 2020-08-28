package com.mrcruz.bikestore.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrcruz.bikestore.model.Brand;
import com.mrcruz.bikestore.model.Customer;
import com.mrcruz.bikestore.model.Order;
import com.mrcruz.bikestore.model.OrderItem;
import com.mrcruz.bikestore.model.Product;
import com.mrcruz.bikestore.model.Store;
import com.mrcruz.bikestore.service.PopularProductDTO;
import com.mrcruz.bikestore.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("/popular-products")
	public List<Product> getPopularProduct() {
		return reportService.getPopularProduct();
		
	}
	
	@GetMapping("/brand-more-products")
	public Brand getBrandMoreProducts() {
		return reportService.getBrandMoreProducts();
		
	}
	
	@GetMapping("/customers-more-orders")
	public List<Customer> getCustomersOrders() {
		return reportService.getCustomerMoreOrders();
		
	}
	
	@GetMapping("/stores-city/{id}")
	public List<Store>  getStoresByCustomerCity(@PathVariable(value="id") Long id) {
		return reportService.getStoresByCity(id);
		
	}
	
	@GetMapping("/orders-customer/{id}")
	public List<Order>  getCustomerOrders(@PathVariable(value="id") Long idCustomer) {
		return reportService.getOrdersByCustomer(idCustomer);
		
	}
	
	@GetMapping("/orders-date/{startDate}/{endDate}")
	public List<Order>  getOrdersDate(@PathVariable(value="startDate") OffsetDateTime startDate,
			@PathVariable(value="endDate") OffsetDateTime endDate) {
		return reportService.getOrdersByDate(startDate, endDate);
		
	}
	
	

}
