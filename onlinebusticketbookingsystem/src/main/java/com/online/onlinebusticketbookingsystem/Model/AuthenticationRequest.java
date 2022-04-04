package com.online.onlinebusticketbookingsystem.Model;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {



	private static final long serialVersionUID = 5926468583005150707L;

	private String name;

	private String password;

	public AuthenticationRequest() {

	}



	public AuthenticationRequest(String name, String password) {

		this.setName(name);

		this.setPassword(password);

	}



	public String getName() {

		return name;

	}



	public void setName(String name) {

		this.name = name;

	}



	public String getPassword() {

		return password;

	}



	public void setPassword(String password) {

		this.password = password;

	}



}