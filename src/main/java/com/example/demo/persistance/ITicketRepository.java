package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entiteien.Customer;
import com.example.demo.entiteien.Ticket;

public interface ITicketRepository extends JpaRepository<Ticket, Long> {
	List<Ticket> findByCustomer(Customer customer);
	
}
