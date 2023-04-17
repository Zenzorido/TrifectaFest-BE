package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entiteien.Artist;
import com.example.demo.entiteien.Festival;
import com.example.demo.entiteien.Organizer;
import com.example.demo.persistance.IOrganizerRepository;
import com.example.demo.service.ArtistService;
import com.example.demo.service.OrganizerService;

@RestController
public class OrganizerEndpoint {
	
	@Autowired
	OrganizerService service;

	@GetMapping("api/organizer/newempty")
	public void saveEmpty() {
		service.save(new Organizer());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="api/organizer/new")
	public boolean saveNew(@RequestBody Organizer o) {
		service.save(o);
		 return true;
	}
	
	@GetMapping("api/organizer/all")
	public List<Organizer> getAll() {
		return service.findAll();
	}
	
	@GetMapping("api/organizer/get/{id}")
	public Organizer getById(@PathVariable long id) {
		return service.findById(id);
		
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="api/organizer/update/{id}")
	public boolean update(@RequestBody Organizer o, @PathVariable long id) {
		service.update(o, id);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="api/organizer/delete/{id}")
	public boolean delete( @PathVariable long id) {
		service.delete(id);
		return true;
	}
	
	@PostMapping("api/organizer/newfestival/{id}")
	public boolean newFestival(@PathVariable("id") long id, @RequestBody Festival festival) {
		service.createFestival(id, festival);
		return true;
	}
}
