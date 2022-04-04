package com.online.busticketbookingsystem.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.online.busticketbookingsystem.UserRepository.HomeRepo;

public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private HomeRepo UserRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserDetails user = (UserDetails) UserRepo.findByEmail(email);
		if(user==null) {
			System.out.println("null");
			throw new UsernameNotFoundException("NOT FOUND");
			
		}
		else {
			
		}
			return new org.springframework.security.core.userdetails.User(((com.online.busticketbookingsystem.Models.UserDetails) user).getEmail(),user.getPassword(),new ArrayList<>());
		// TODO Auto-generated method stub
	
	}
	



}
