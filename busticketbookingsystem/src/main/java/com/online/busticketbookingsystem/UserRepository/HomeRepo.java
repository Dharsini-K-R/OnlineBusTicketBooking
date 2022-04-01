package com.online.busticketbookingsystem.UserRepository;

import org.springframework.data.repository.CrudRepository;

import com.online.busticketbookingsystem.Models.UserDetails;

public interface HomeRepo extends CrudRepository<UserDetails,Integer>{

	UserDetails findByEmail(String email);

}

