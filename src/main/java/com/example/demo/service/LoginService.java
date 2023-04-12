package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entiteien.Artist;
import com.example.demo.entiteien.Customer;
import com.example.demo.entiteien.Organizer;
import com.example.demo.entiteien.Person;
import com.example.demo.persistance.IArtistRepository;
import com.example.demo.persistance.ICustomerRepository;
import com.example.demo.persistance.ILoginRepository;
import com.example.demo.persistance.IOrganizerRepository;

@Service

public class LoginService {
	
	@Autowired
	private ILoginRepository repo;
	
	@Autowired
	IOrganizerRepository organizerRepo;
	
	@Autowired
	ICustomerRepository customerRepo;
	
	@Autowired
	IArtistRepository artistRepo;
	
	
	public Person userLogin(Customer a) {
		List<Person> ps = new ArrayList<>();
		ps.addAll(findAllCustomer());
		ps.addAll(findAllArtist());
		ps.addAll(findAllOrganizer());
		
		for (Person person : ps) {
				if(person.compareLogin(a.getEmail(),a.getPassword())) {
				return person;
			}
		}
		
		return null;
	}
	
	public List<Customer> findAllCustomer(){
		return customerRepo.findAll(); //< list van persons maken
	}
	public List<Artist> findAllArtist(){
		return artistRepo.findAll(); //< list van persons maken
	}
	public List<Organizer> findAllOrganizer(){
		return organizerRepo.findAll(); //< list van persons maken
	}
}
