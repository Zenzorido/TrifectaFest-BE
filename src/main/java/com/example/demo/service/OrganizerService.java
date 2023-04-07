package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entiteien.Artist;
import com.example.demo.entiteien.Festival;
import com.example.demo.entiteien.Organizer;
import com.example.demo.persistance.IFestivalRepository;
import com.example.demo.persistance.IOrganizerRepository;

@Service
public class OrganizerService {

	@Autowired
	IOrganizerRepository repo;
	
	@Autowired
	IFestivalRepository festivalRepo;

	public void createFestival(long id, Festival festival) {
		// TODO Auto-generated method stub
		Festival a = festivalRepo.save(festival);//transient
		
		Organizer b = repo.findById(id).get();
		a.setOrganizer(b);
		festivalRepo.save(a);
	}
	
	public void save() {
		repo.save(new Organizer());
	}
	
	public boolean save(Organizer a) {
		repo.save(a);
		return true;
	}
	
	public List<Organizer> findAll(){
		return repo.findAll();
	}
	
	public Organizer findById(long id) {
		return repo.findById(id).get();
	}
	
	public boolean update(Organizer a, long id) {
		Organizer organizer = repo.findById(id).get();
		organizer.setEmail(a.getEmail());
		organizer.setName(a.getName());
		organizer.setPassword(a.getPassword());
		repo.save(organizer);
		return true;
	}
	
	public boolean delete(long id) {
		repo.deleteById(id);
		return true;
	}
	
}
