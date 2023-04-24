package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entiteien.Customer;
import com.example.demo.entiteien.Ticket;
import com.example.demo.persistance.ICustomerRepository;
import com.example.demo.persistance.IFestivalRepository;
import com.example.demo.persistance.ITicketRepository;

@Service
public class TicketService {

	@Autowired
	ITicketRepository repo;
	
	@Autowired
	ICustomerRepository customerRepo;
	
	@Autowired
	IFestivalRepository festivalRepo;
	
	
	public boolean save() {
		repo.save(new Ticket());
		return true;
	}
	
	public boolean save(Ticket t) {
		repo.save(t);
		return true;
	}
	
	public boolean save(Ticket t, long cid, long fid) {
		t.setCustomer(customerRepo.findById(cid).get());
		t.setFestival(festivalRepo.findById(fid).get());
		repo.save(t);
		return true;
	}
	
	public List<Ticket> findAll(){
		return repo.findAll();
	}
	
	public Ticket findById(long id) {
		return repo.findById(id).get();
	}
	
	public List<Ticket> findByCustomer(long id){
		Customer c = customerRepo.findById(id).get();
		return repo.findByCustomer(c);
	}
	
	public boolean update(Ticket a, long id) {
		Ticket t = repo.findById(id).get();
		t.setStartDate(a.getStartDate());
		t.setEndDate(a.getEndDate());
		
		repo.save(t);
		return true;
	}
	
	public boolean delete(long id) {
		repo.deleteById(id);
		return true;
	}
	
}
