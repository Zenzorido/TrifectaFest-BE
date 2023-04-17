package com.example.demo.entiteien;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Festival {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 100)
	private String name;
	
	private String location;

	private LocalDateTime beginDate;

	private LocalDateTime endDate;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "festival")
	private List<Ticket> tickets;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "festival")
	private List<Stage> stages;

	@JsonIgnore
	@ManyToOne(optional = true) //Hoort false te zijn
	private Organizer organizer;
	

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

	public LocalDateTime getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(LocalDateTime beginDate) {
		this.beginDate = beginDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Stage> getStages() {
		return stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	@JsonIgnore
	public Organizer getOrganizer() {
		return organizer;
	
	}

	@JsonIgnore
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
}
