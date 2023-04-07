package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entiteien.BookingRequest;
import com.example.demo.service.BookingRequestService;

@RestController
public class BookingRequestEndpoint {
	
	@Autowired
	BookingRequestService service;
	
	@GetMapping("/api/bookingrequest/all")
	public List<BookingRequest> getAll() {
		return service.findAll();
	}
	@GetMapping("/api/bookingrequest/newempty")
	public void saveEmpty() {
		service.save(new BookingRequest());
	}
	
	@GetMapping("api/bookingrequest/get/{id}")
	public BookingRequest getById(@PathVariable long id) {
		return service.findById(id);
		
	}
	 
	
	@RequestMapping(method=RequestMethod.POST, value="/api/bookingrequest/new")
	public boolean create(@RequestBody BookingRequest f) {
		service.save(f);
		return true;
	}
	

	@RequestMapping(method=RequestMethod.PUT, value="/api/bookingrequest/update/{id}")
	public boolean update(@RequestBody BookingRequest f, @PathVariable long id) {
		service.update(f,id);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/bookingrequest/delete/{id}")
	public boolean delete( @PathVariable long id) {
		return service.delete(id);
	}
	
	
	
}
