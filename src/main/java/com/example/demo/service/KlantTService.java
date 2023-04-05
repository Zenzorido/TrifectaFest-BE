package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entiteien.Customer;
import com.example.demo.persistance.ICustomerRepository;

@Component
public class KlantTService {

	@Autowired
	ICustomerRepository repo;
	
	public void opslaanInput(String text) {
		Customer c = new Customer();
		c.setName(text);
		repo.save(c);
	}
}
