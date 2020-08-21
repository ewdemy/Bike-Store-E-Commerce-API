package com.mrcruz.bikestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrcruz.bikestore.model.Customer;
import com.mrcruz.bikestore.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void delete(Long id) {
		customerRepository.deleteById(id);
	}

}
