package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KlantTService;

@RestController
public class KlantTEndpoint {

	int a = 2;
	
	@Autowired
	KlantTService service;
	
	@GetMapping("thomas1")
	public String proberen() {
		return "hij doet het!";
	}
	
	@GetMapping("thomas2/{rrr}")
	public String eenTweedePoging(@PathVariable("rrr") String abc) {
		service.opslaanInput(abc); 
		return "dit is de tweede method!" + abc;
	}
	
}
