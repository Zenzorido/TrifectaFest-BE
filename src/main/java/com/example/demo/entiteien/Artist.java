package com.example.demo.entiteien;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Artist extends Person {

	@Enumerated(EnumType.STRING)
	private ArtistType type;

	@Column(length = 500)
	private String description;

	@Column(length = 50)
	private String genre;

	@Column(length = 20)
	private String rekeningNummer;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = false, mappedBy = "artist")
	private List<BookingRequest> bookingRequests;

	@Override
	public PersonRole getRole() {
		// TODO Auto-generated method stub
		return PersonRole.Artist;
	}

	public ArtistType getType() {
		return type;
	}

	public void setType(ArtistType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRekeningNummer() {
		return rekeningNummer;
	}

	public void setRekeningNummer(String rekeningNummer) {
		this.rekeningNummer = rekeningNummer;
	}

	public List<BookingRequest> getBookingRequests() {
		return bookingRequests;
	}

	public void setBookingRequests(List<BookingRequest> bookingRequests) {
		this.bookingRequests = bookingRequests;
	}
	
	

}
