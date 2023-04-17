package com.example.demo.persistance;

import com.example.demo.entiteien.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;

@Component
public interface IBookingRequestRepository extends JpaRepository<BookingRequest , Long > {
	List<BookingRequest> findByArtist(Artist artist);

}
