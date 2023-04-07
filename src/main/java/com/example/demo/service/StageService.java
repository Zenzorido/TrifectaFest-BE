package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entiteien.Artist;
import com.example.demo.entiteien.Stage;
import com.example.demo.persistance.IStageRepository;

@Service
public class StageService {

	@Autowired
	public IStageRepository repo;
	
	public void save() {
		repo.save(new Stage());
	}
	
	public boolean save(Stage a) {
		repo.save(a);
		return true;
	}
	
	public List<Stage> findAll(){
		return repo.findAll();
	}
	
	public Stage findById(long id) {
		return repo.findById(id).get();
	}
	
	public boolean update(Stage a, long id) {
		Stage stage = repo.findById(id).get();
		stage.setCapacity(a.getCapacity());
		stage.setName(a.getName());
		
		repo.save(stage);
		return true;
	}
	
	public boolean delete(long id) {
		repo.deleteById(id);
		return true;
	}
}
