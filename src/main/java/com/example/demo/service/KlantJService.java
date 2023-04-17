package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entiteien.Customer;
import com.example.demo.persistance.ICustomerRepository;

@Component
public class KlantJService {

	@Autowired
	ICustomerRepository repo;
	
	public void opslaan(String text) {
		Customer C = new Customer();
		C.setName(text);
		repo.save(C);
	}
}
