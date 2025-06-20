package com.multi.step.form.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmailOTP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String email;
	private String username;
	private String otp;
	private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}
	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}
	public EmailOTP(int id, String email, String username, String otp, LocalDateTime createdAt,
			LocalDateTime expiresAt) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.otp = otp;
		this.createdAt = createdAt;
		this.expiresAt = expiresAt;
	}
	public EmailOTP() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmailOTP [id=" + id + ", email=" + email + ", username=" + username + ", otp=" + otp + ", createdAt="
				+ createdAt + ", expiresAt=" + expiresAt + "]";
	}
}
