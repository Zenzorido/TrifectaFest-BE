package com.example.demo.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.entiteien.Person;

@Component
public interface ILoginRepository extends JpaRepository<Person, Long> {

	
}
