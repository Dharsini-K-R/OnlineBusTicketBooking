package com.online.busticketbookingsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.online.busticketbookingsystem.Models.JwtToken;
import com.online.busticketbookingsystem.Models.UserDetails;
import com.online.busticketbookingsystem.Service.MyUserDetailsService;
import com.online.busticketbookingsystem.UserRepository.HomeRepo;
import com.online.busticketbookingsystem.util.JwtUtil;

@Controller
public class User_Controller {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@RequestMapping("/hello")
	public String firstPage() {
		return "Hello World";
	}
	@RequestMapping("/")
	public String header() {
		return "header";

	}
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login.jsp");
		mav.addObject("userlogin", new User());
		

		return mav;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestParam String email,@RequestParam String password) throws Exception{
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(email);

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtToken(jwt));
	}
	}