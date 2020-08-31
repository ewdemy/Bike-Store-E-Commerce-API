package com.mrcruz.bikestore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public String hello() {
		return "Welcome to OSF Bike Store!!!";
	}
}
