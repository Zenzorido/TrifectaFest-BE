package com.example.demo.entiteien;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;

	protected String name;

	protected String email;

	protected String password;

	public abstract PersonRole getRole();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean compareLogin(String email, String password) {
		
			if(email.equals(this.email)) {
				if(password.equals(this.password)) {
				return true;
			}
				String s = 'b'+63+"a";
				
		}
			return false;
	}

}
