package com.mrcruz.bikestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrcruz.bikestore.model.OrderItem;
import com.mrcruz.bikestore.model.Product;
import com.mrcruz.bikestore.service.PopularProductDTO;
import com.mrcruz.bikestore.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping
	public List<Product> getPopularProduct() {
		return reportService.getPopularProduct();
		
	}

}
