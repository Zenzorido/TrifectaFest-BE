package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entiteien.Customer;
import com.example.demo.entiteien.Person;
import com.example.demo.service.LoginService;

@RestController
public class LoginEndpoint {

	@Autowired
	private LoginService service;
	
	 @ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/api/login/user")
	public Person create(@RequestBody Customer a) {
		try {
			return(service.userLogin(a));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
}
