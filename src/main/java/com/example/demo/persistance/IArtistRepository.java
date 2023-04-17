package com.example.demo.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.entiteien.Artist;

@Component
public interface IArtistRepository extends JpaRepository<Artist, Long> {

	
}
