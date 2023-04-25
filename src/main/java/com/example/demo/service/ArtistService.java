package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entiteien.Artist;
import com.example.demo.persistance.IArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	private IArtistRepository repo;

	public void save() {
		repo.save(new Artist());
	}
	
	public boolean save(Artist a) {
		repo.save(a);
		return true;
	}
	
	public List<Artist> findAll(){
		return repo.findAll();
	}
	
	public Artist findById(long id) {
		return repo.findById(id).get();
	}
	
	public boolean update(Artist a, long id) {
		Artist artist = repo.findById(id).get();
		
		artist.setName(a.getName());
		artist.setDescription(a.getDescription());
		artist.setEmail(a.getEmail());
		artist.setGenre(a.getGenre());
		artist.setPassword(a.getPassword());
		artist.setRekeningNummer(a.getRekeningNummer());
		artist.setType(a.getType());
		artist.setBookingRequests(a.getBookingRequests());
		
		repo.save(artist);
		return true;
	}
	
	public boolean delete(long id) {
		repo.deleteById(id);
		return true;
	}
	
}
