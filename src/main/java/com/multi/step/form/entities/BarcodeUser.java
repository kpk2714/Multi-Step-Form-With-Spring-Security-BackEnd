package com.multi.step.form.entities;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class BarcodeUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String email;
	private String barcodeUrl;
	private String name;
	
	@Lob
	@Column(length = 100000000)
	private byte[] data;

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

	public String getBarcodeUrl() {
		return barcodeUrl;
	}

	public void setBarcodeUrl(String barcodeUrl) {
		this.barcodeUrl = barcodeUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public BarcodeUser(int id, String username, String email, String barcodeUrl, String name, byte[] data) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.barcodeUrl = barcodeUrl;
		this.name = name;
		this.data = data;
	}

	public BarcodeUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BarcodeUser [id=" + id + ", username=" + username + ", email=" + email + ", barcodeUrl=" + barcodeUrl
				+ ", name=" + name + ", data=" + Arrays.toString(data) + "]";
	}
}
