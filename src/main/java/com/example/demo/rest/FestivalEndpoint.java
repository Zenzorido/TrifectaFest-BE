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

import com.example.demo.entiteien.Festival;
import com.example.demo.persistance.IFestivalRepository;
import com.example.demo.service.FestivalService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
public class FestivalEndpoint {
	
//	@Autowired
//	IFestivalRepository repo;
	
	@Autowired
	FestivalService service;

	@GetMapping("/api/festival/newempty")
	public void saveEmpty() {
		service.save(new Festival());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/api/festival/new")
	public boolean saveNew(@RequestBody Festival f) {
		service.save(f);
		 return true;
	}
	
	@GetMapping("/api/festival/all")
	public List<Festival> getAll() {
		return service.findAll();
	}
	
	@GetMapping("/api/festival/get/{id}")
	public Festival getById(@PathVariable long id) {
		return service.findById(id);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/api/festival/update/{id}")
	public boolean update(@RequestBody Festival f, @PathVariable long id) {
		service.update(f, id);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/festival/delete/{id}")
	public boolean delete( @PathVariable long id) {
		service.delete(id);
		return true;
	}
	
	@GetMapping("/api/festival/organizer/{festivalid}/{organizerid}")
	public String addOrganizer(@PathVariable("festivalid") long festivalid, @PathVariable("organizerid") long organizerid) {
		System.out.println(festivalid);
		System.out.println(organizerid);
		service.newFestival(festivalid, organizerid);
		return "";
	}
		

}
