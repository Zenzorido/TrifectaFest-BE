package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entiteien.Ticket;
import com.example.demo.service.TicketService;

@RestController
public class TicketEndpoint {

	@Autowired
	TicketService service;
	
	@GetMapping("/api/ticket/all")
	public List<Ticket> getAll() {
		return service.findAll();
	}
	
	@GetMapping("/api/ticket/get/{id}")
	public Ticket getById(@PathVariable long id) {
		return service.findById(id);
	}
	
	@GetMapping("/api/customer/ticket/get/{id}")
	public List<Ticket>getTicketsOfCustomer(@PathVariable long id){
		return service.findByCustomer(id);
	}
	
	@GetMapping("/api/ticket/newempty") //<- deze is goed om te proberen
	public void saveEmpty() {
		service.save();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/api/ticket/new") //<- deze is beter
	public boolean saveNewTicket(@RequestBody Ticket a) {
		return service.save(a);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/api/ticket/new/{cid}/{fid}") //<- deze is beter
	public boolean saveNew(@RequestBody Ticket a, @PathVariable("cid") long cid, @PathVariable("fid") long fid) {
		return service.save(a, cid, fid);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/api/ticket/update/{id}")
	public boolean update(@RequestBody Ticket a, @PathVariable long id) {
		return service.update(a, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/ticket/delete/{id}")
	public boolean delete( @PathVariable long id) {
		return service.delete(id);
	}
	
	@GetMapping("/api/ticket/has/{cid}/{fid}")
	@ResponseBody
	public boolean hasTicket(@PathVariable("cid") long cid, @PathVariable("fid") long fid) {
		return service.hasTicket(cid, fid);
		
	}
	
}
