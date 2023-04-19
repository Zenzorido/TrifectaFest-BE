package com.example.demo.entiteien;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
 
@Entity
public class BookingRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private BookingRequestStatus status = BookingRequestStatus.pending;
	
	private int day;
	 
	private int timeSlot;
	
	private boolean needVj;
	
	private boolean hasVj;
	
	private String synopsis;
	
	@ManyToOne(optional = true)//moet false
	private Artist artist;
	
	@ManyToOne(optional = true) //moet false
	private Stage stage;
	
	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "bookingRequest")
	private Booking booking;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BookingRequestStatus getStatus() {
		return status;
	}

	public void setStatus(BookingRequestStatus status) {
		this.status = status;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	public boolean isNeedVj() {
		return needVj;
	}

	public void setNeedVj(boolean needVj) {
		this.needVj = needVj;
	}

	public boolean isHasVj() {
		return hasVj;
	}

	public void setHasVj(boolean hasVj) {
		this.hasVj = hasVj;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}
