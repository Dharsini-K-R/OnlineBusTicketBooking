package com.online.onlinebusticketbookingsystem.Repository;

import org.springframework.data.repository.CrudRepository;

import com.online.onlinebusticketbookingsystem.Model.TicketBookingModelJwt;

public interface TicketBookingRepo extends CrudRepository<TicketBookingModelJwt,Integer> {
	

 TicketBookingModelJwt findByName(String name);


}