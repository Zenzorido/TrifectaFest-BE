package com.example.demo.entiteien;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Organizer extends Person {

	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "organizer")
	private List<Festival> festivals;

	public List<Festival> getFestivals() {
		return festivals;
	}

	public void setFestivals(List<Festival> festivals) {
		this.festivals = festivals;
	}

	@Override
	public PersonRole getRole() {
		// TODO Auto-generated method stub
		return PersonRole.Organizer;
	}
}
