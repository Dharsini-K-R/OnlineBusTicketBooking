package com.online.busticketbookingsystem.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.online.busticketbookingsystem.Filters.JwtRequestFilter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
@Override
protected void configure(AuthenticationManagerBuilder auth)throws Exception{
	auth.userDetailsService(myUserDetailsService);
}
@SuppressWarnings("deprecation")
@Bean
public PasswordEncoder getPasswordEncoder() {
	return NoOpPasswordEncoder.getInstance();
}
@Override
protected void configure(HttpSecurity httpSecurity) throws Exception {
	httpSecurity.csrf().disable()
			.authorizeRequests().antMatchers("/authenticate","/login").permitAll().
					anyRequest().authenticated().and().
					exceptionHandling().and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

}
@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception{
	return super.authenticationManagerBean();
}
}
