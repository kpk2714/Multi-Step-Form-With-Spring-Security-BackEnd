package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Width {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userId;
	private int width;
	private String formname;
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getFormname() {
		return formname;
	}
	public void setFormname(String formname) {
		this.formname = formname;
	}
	public Width(int id, String userId, int width, String formname) {
		super();
		this.id = id;
		this.userId = userId;
		this.width = width;
		this.formname = formname;
	}
	public Width() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Width [id=" + id + ", userId=" + userId + ", width=" + width + ", formname=" + formname + "]";
	}
}
