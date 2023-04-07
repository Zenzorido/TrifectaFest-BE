package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entiteien.Artist;
import com.example.demo.entiteien.Festival;
import com.example.demo.entiteien.Organizer;
import com.example.demo.persistance.IFestivalRepository;
import com.example.demo.persistance.IOrganizerRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class FestivalService {

	@Autowired
	IOrganizerRepository organizerRepo;
	
	@Autowired
	IFestivalRepository festivalRepo;
	
	
	
	public boolean newFestival(long festivalid, long organizerid) {
		// TODO Auto-generated method stub
		Organizer temp = organizerRepo.findById(organizerid).get();
		Festival festival = festivalRepo.findById(festivalid).get();
		
		festival.setOrganizer(temp);
		festivalRepo.save(festival);
		
		return true;
	}

	public void save() {
		festivalRepo.save(new Festival());
	}
	
	public boolean save(Festival a) {
		festivalRepo.save(a);
		return true;
	}
	
	public List<Festival> findAll(){
		return festivalRepo.findAll();
	}
	
	public Festival findById(long id) {
		return festivalRepo.findById(id).get();
	}
	
	public boolean update(Festival a, long id) {
		Festival festival = festivalRepo.findById(id).get();
		festival.setBeginDate(a.getBeginDate());
		festival.setEndDate(a.getEndDate());
		festival.setName(a.getName());
//		festival.setOrganizer(a.getOrganizer());
		festivalRepo.save(festival);
		return true;
	}
	
	public boolean delete(long id) {
		festivalRepo.deleteById(id);
		return true;
	}
	
}
