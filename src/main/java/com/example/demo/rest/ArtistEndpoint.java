package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entiteien.Artist;
import com.example.demo.service.ArtistService;

@RestController
public class ArtistEndpoint {
	@Autowired
	ArtistService service;
	
	@GetMapping("/api/artist/all")
	public List<Artist> getAll() {
		return service.findAll();
	}
	
	@GetMapping("/api/artist/get/{id}")
	public Artist getById(@PathVariable long id) {
		return service.findById(id);
	}
	
	@GetMapping("/api/artist/newempty") //<- deze is goed om te proberen
	public void saveEmpty() {
		System.out.println("we zijn in het endpoint");
		service.save();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/api/artist/new") //<- deze is beter
	public boolean saveNew(@RequestBody Artist a) {
		return service.save(a);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/api/artist/update/{id}")
	public boolean update(@RequestBody Artist a, @PathVariable long id) {
		return service.update(a, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/artist/delete/{id}")
	public boolean delete( @PathVariable long id) {
		return service.delete(id);
	}
}

