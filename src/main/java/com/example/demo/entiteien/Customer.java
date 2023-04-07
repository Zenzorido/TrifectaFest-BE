package com.example.demo.entiteien;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Customer extends Person {

	@Enumerated(EnumType.STRING)
	private GenderType gender;
	
	private int age;
	@Column(length = 50)
	private String region;
	
	private int phoneNumber;
	@Column(length = 50)
	private String favoriteBand;
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "customer")
		private List<Ticket> tickets;
	
	
	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFavoriteBand() {
		return favoriteBand;
	}

	public void setFavoriteBand(String favoriteBand) {
		this.favoriteBand = favoriteBand;
	}

	@Override
	public PersonRole getRole() {
		// TODO Auto-generated method stub
		return PersonRole.Customer;
	}

}
