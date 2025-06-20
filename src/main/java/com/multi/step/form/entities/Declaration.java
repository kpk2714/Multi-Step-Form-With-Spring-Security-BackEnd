package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Declaration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userId;
	private String declare1;
	private String declare2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDeclare1() {
		return declare1;
	}
	public void setDeclare1(String declare1) {
		this.declare1 = declare1;
	}
	public String getDeclare2() {
		return declare2;
	}
	public void setDeclare2(String declare2) {
		this.declare2 = declare2;
	}
	public Declaration(int id, String userId, String declare1, String declare2) {
		super();
		this.id = id;
		this.userId = userId;
		this.declare1 = declare1;
		this.declare2 = declare2;
	}
	public Declaration() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Declaration [id=" + id + ", userId=" + userId + ", declare1=" + declare1 + ", declare2=" + declare2
				+ "]";
	}
}
