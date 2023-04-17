package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entiteien.Customer;
import com.example.demo.persistance.ICustomerRepository;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerEndpoint {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/api/customer/all")
	public List<Customer> getAll() {
		return service.findAll();
	}

	@GetMapping("customer/{id}")
	public Customer getById(@PathVariable long id) {
		return service.findById(id);
	}

	@GetMapping("/api/customer/saveempty")
	public void saveEmpty() {
		System.out.println("we zijn in het endpoint");
		service.save(new Customer());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/customer/new")
	public void create(@RequestBody Customer a) {
		service.save(a);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/api/customer/{id}")
	public boolean update(@RequestBody Customer a, @PathVariable long id) {
		service.update(a, id);
		return true;
	}


	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/customer/delete/{id}")
	public boolean delete( @PathVariable long id) {
		return service.delete(id);
	}

}
