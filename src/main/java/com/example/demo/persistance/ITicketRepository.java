package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entiteien.Customer;
import com.example.demo.entiteien.Ticket;

public interface ITicketRepository extends JpaRepository<Ticket, Long> {
	List<Ticket> findByCustomer(Customer customer);
	
	@Query(value="SELECT * FROM ticket t WHERE t.customer_id = :cid AND t.festival_id = :fid ", nativeQuery = true )
	public Ticket findByCustomerAndFestival(@Param("cid")long cid, @Param("fid")long fid);
}
