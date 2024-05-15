package com.symatique.SmartSoft.DTO;

import java.util.Set;





public class SignupRequest {

	private String username;

	private String email;

	private Set<String> profile;

	
	
	
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getProfile() {
		return profile;
	}

	public void setProfile(Set<String> profile) {
		this.profile = profile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	 
	 
	  
	}
