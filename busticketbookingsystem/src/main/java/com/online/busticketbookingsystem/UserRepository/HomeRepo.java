package com.online.busticketbookingsystem.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.online.busticketbookingsystem.Models.UserDetails;

public interface HomeRepo extends JpaRepository<UserDetails,Long>{

	UserDetails findByEmail(String email);
	UserDetails findByFirstName(String username);

}

