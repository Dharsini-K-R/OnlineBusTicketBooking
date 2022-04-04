package com.online.onlinebusticketbookingsystem.SecurityConfigurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class TicketBookingSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired

	private TicketBookingJwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;



	@Autowired

	private MyUserDetailsService myUserDetailsService;



	@Autowired

	private JwtRequestFilter jwtRequestFilter;
	@Override

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordencoder());

	}



	@Override

	@Bean

	public AuthenticationManager authenticationManagerBean() throws Exception {

		// TODO Auto-generated method stub

		return super.authenticationManagerBean();

	}



	@Bean(name = "passwordEncoder")

	public  PasswordEncoder passwordencoder() {

		return new BCryptPasswordEncoder();

	}



	@Override

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/","/login", "/signin").permitAll().
		anyRequest().authenticated().and().
		exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);



}



}
