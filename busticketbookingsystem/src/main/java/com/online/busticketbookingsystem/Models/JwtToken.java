package com.online.busticketbookingsystem.Models;

public class JwtToken {
	private final String jwt;

	public String getJwt() {
		return jwt;
	}
	public JwtToken(String jwt) {
		super();
		this.jwt = jwt;
	}
}
