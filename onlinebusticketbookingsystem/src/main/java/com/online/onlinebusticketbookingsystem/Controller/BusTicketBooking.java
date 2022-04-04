package com.online.onlinebusticketbookingsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.online.onlinebusticketbookingsystem.Model.AuthenticationRequest;
import com.online.onlinebusticketbookingsystem.Model.AuthenticationResponse;
import com.online.onlinebusticketbookingsystem.Model.TicketBookingModelJwt;
import com.online.onlinebusticketbookingsystem.Repository.TicketBookingRepo;
import com.online.onlinebusticketbookingsystem.SecurityConfigurer.JwtTokenUtil;
import com.online.onlinebusticketbookingsystem.SecurityConfigurer.MyUserDetailsService;

@Controller
public class BusTicketBooking {
	@Autowired
	TicketBookingRepo repo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private MyUserDetailsService myuserDetailsService;
	
	@RequestMapping("/")
	public String index()
	{
		return "index.jsp";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	// ResponseEntity is HTTP
	

	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
					(authenticationRequest.getName(), authenticationRequest.getPassword()));
			} 
		catch (BadCredentialsException e) {

			throw new Exception("Incorrect Username or Password");

		}
		final UserDetails userDetails = myuserDetailsService.loadUserByUsername(authenticationRequest.getName());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		}
	@RequestMapping(value = "/signin", method = RequestMethod.POST)

	public ResponseEntity<?> saveUser(@RequestBody TicketBookingModelJwt user) throws Exception {

		return ResponseEntity.ok(myuserDetailsService.save(user));

	}
}