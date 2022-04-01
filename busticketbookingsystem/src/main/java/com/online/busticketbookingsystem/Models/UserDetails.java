package com.online.busticketbookingsystem.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="details")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String name;
	public String dob;
	public String address;
	public String phone;
	public String email;
	public String password;
	/*public UserDetails(){
		
	}
	public UserDetails(String name, String dob, String address, String phone, String email, String password){
		this.name=name;
		this.dob=dob;
		this.address=address;
		this.phone=phone;
		this.email=email;
		this.password=password;
	}*/

	public int getId() {
		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {

		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + "]";
	}

}

