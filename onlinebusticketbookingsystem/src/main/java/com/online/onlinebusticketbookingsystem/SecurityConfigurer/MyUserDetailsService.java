package com.online.onlinebusticketbookingsystem.SecurityConfigurer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.online.onlinebusticketbookingsystem.Model.TicketBookingModelJwt;
import com.online.onlinebusticketbookingsystem.Repository.TicketBookingRepo;
@Component
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private  TicketBookingRepo  repo;
	@Autowired
	@Lazy
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
	TicketBookingModelJwt user = repo.findByName(name);// jpa

		if (user == null) {

			System.out.println("");

			throw new UsernameNotFoundException("User not found with username: " + name);

		}

		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),

				new ArrayList<>());

	}



	public TicketBookingModelJwt save(TicketBookingModelJwt user) {

		TicketBookingModelJwt newUser = new TicketBookingModelJwt();

		newUser.setName(user.getName());

		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));

		newUser.setEmail(user.getEmail());

		return repo.save(newUser);

	}



}
