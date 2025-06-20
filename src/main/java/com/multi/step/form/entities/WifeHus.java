package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WifeHus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String wifeHus;
	private String userId;
	private String wifeHusRelationship;
	private String wifeHusFirstname;
	private String wifeHusMiddlename;
	private String wifeHusLastname;
	private String wifeHusGender;
	private String wifeHusDobf;
	private String wifeHusNationality;
	private String wifeHusQualification;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWifeHus() {
		return wifeHus;
	}
	public void setWifeHus(String wifeHus) {
		this.wifeHus = wifeHus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getWifeHusRelationship() {
		return wifeHusRelationship;
	}
	public void setWifeHusRelationship(String wifeHusRelationship) {
		this.wifeHusRelationship = wifeHusRelationship;
	}
	public String getWifeHusFirstname() {
		return wifeHusFirstname;
	}
	public void setWifeHusFirstname(String wifeHusFirstname) {
		this.wifeHusFirstname = wifeHusFirstname;
	}
	public String getWifeHusMiddlename() {
		return wifeHusMiddlename;
	}
	public void setWifeHusMiddlename(String wifeHusMiddlename) {
		this.wifeHusMiddlename = wifeHusMiddlename;
	}
	public String getWifeHusLastname() {
		return wifeHusLastname;
	}
	public void setWifeHusLastname(String wifeHusLastname) {
		this.wifeHusLastname = wifeHusLastname;
	}
	public String getWifeHusGender() {
		return wifeHusGender;
	}
	public void setWifeHusGender(String wifeHusGender) {
		this.wifeHusGender = wifeHusGender;
	}
	public String getWifeHusDobf() {
		return wifeHusDobf;
	}
	public void setWifeHusDobf(String wifeHusDobf) {
		this.wifeHusDobf = wifeHusDobf;
	}
	public String getWifeHusNationality() {
		return wifeHusNationality;
	}
	public void setWifeHusNationality(String wifeHusNationality) {
		this.wifeHusNationality = wifeHusNationality;
	}
	public String getWifeHusQualification() {
		return wifeHusQualification;
	}
	public void setWifeHusQualification(String wifeHusQualification) {
		this.wifeHusQualification = wifeHusQualification;
	}
	public WifeHus(int id, String wifeHus, String userId, String wifeHusRelationship, String wifeHusFirstname,
			String wifeHusMiddlename, String wifeHusLastname, String wifeHusGender, String wifeHusDobf,
			String wifeHusNationality, String wifeHusQualification) {
		super();
		this.id = id;
		this.wifeHus = wifeHus;
		this.userId = userId;
		this.wifeHusRelationship = wifeHusRelationship;
		this.wifeHusFirstname = wifeHusFirstname;
		this.wifeHusMiddlename = wifeHusMiddlename;
		this.wifeHusLastname = wifeHusLastname;
		this.wifeHusGender = wifeHusGender;
		this.wifeHusDobf = wifeHusDobf;
		this.wifeHusNationality = wifeHusNationality;
		this.wifeHusQualification = wifeHusQualification;
	}
	public WifeHus() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WifeHus [id=" + id + ", wifeHus=" + wifeHus + ", userId=" + userId + ", wifeHusRelationship="
				+ wifeHusRelationship + ", wifeHusFirstname=" + wifeHusFirstname + ", wifeHusMiddlename="
				+ wifeHusMiddlename + ", wifeHusLastname=" + wifeHusLastname + ", wifeHusGender=" + wifeHusGender
				+ ", wifeHusDobf=" + wifeHusDobf + ", wifeHusNationality=" + wifeHusNationality
				+ ", wifeHusQualification=" + wifeHusQualification + "]";
	}
}
