package com.example.demo.entiteien;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
 
@Entity
public class Stage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private int capacity;
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "stage")
	private List<BookingRequest> bookingRequests;
}
