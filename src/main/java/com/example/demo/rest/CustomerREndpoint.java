package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerRService;

@RestController
public class CustomerREndpoint {
	int a = 2;
	@Autowired
	CustomerRService service;
	
	
	@GetMapping("richard1")
	public String Proberen() {
		return "hij doet het!";
	}

	@GetMapping("richard2/{rrr}")
	public String Proberen2(@PathVariable("rrr")String abc) {
		
		service.opslaanMaar(abc);
		
		return "Doet deze het nou dan ook?" + abc;
	}
}

