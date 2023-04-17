package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KlantJService;

@RestController
public class KlantJEndpoint {
	
	@Autowired
	KlantJService mijnService;

	@GetMapping("jelle1")
	public String proberen() {
		System.out.println("hij doet!");
		return "Hoi!";
	}
	
	@GetMapping("jelle2/{pathvar}")
	public String probeertwee(@PathVariable("pathvar")String abc) {
		System.out.println("hij doet!");
		
		mijnService.opslaan(abc);
		
		return "Hoideel2" + abc;
	}
}
