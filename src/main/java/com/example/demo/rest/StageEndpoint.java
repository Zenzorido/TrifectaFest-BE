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
import com.example.demo.entiteien.Stage;
import com.example.demo.service.StageService;

@RestController
public class StageEndpoint {

	@Autowired
	StageService service;
	
	@GetMapping("/api/stage/all")
	public List<Stage> getAll() {
		return service.findAll();
	}
	
	@GetMapping("/api/stage/get/{id}")
	public Stage getById(@PathVariable long id) {
		return service.findById(id);
	}
	
	@GetMapping("/api/stage/newempty") //<- deze is goed om te proberen
	public void saveEmpty() {
		service.save();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/api/stage/new") //<- deze is beter
	public boolean saveNew(@RequestBody Stage a) {
		return service.save(a);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/api/stage/update/{id}")
	public boolean update(@RequestBody Stage a, @PathVariable long id) {
		return service.update(a, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/stage/delete/{id}")
	public boolean delete( @PathVariable long id) {
		return service.delete(id);
	}
}
