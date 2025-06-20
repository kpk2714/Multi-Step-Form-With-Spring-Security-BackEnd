package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuthenticatedUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String email;
	private String secretKey;
	private boolean isAuthBind;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public boolean isAuthBind() {
		return isAuthBind;
	}
	public void setAuthBind(boolean isAuthBind) {
		this.isAuthBind = isAuthBind;
	}
	public AuthenticatedUser(int id, String username, String email, String secretKey, boolean isAuthBind) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.secretKey = secretKey;
		this.isAuthBind = isAuthBind;
	}
	public AuthenticatedUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AuthenticatedUser [id=" + id + ", username=" + username + ", email=" + email + ", secretKey="
				+ secretKey + ", isAuthBind=" + isAuthBind + "]";
	}
	
	
}
