package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mother {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String mother;
	private String userId;
	private String moRelationship;
	private String moFirstname;
	private String moMiddlename;
	private String moLastname;
	private String moGender;
	private String moDobf;
	private String moNationality;
	private String moQualification;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMoRelationship() {
		return moRelationship;
	}
	public void setMoRelationship(String moRelationship) {
		this.moRelationship = moRelationship;
	}
	public String getMoFirstname() {
		return moFirstname;
	}
	public void setMoFirstname(String moFirstname) {
		this.moFirstname = moFirstname;
	}
	public String getMoMiddlename() {
		return moMiddlename;
	}
	public void setMoMiddlename(String moMiddlename) {
		this.moMiddlename = moMiddlename;
	}
	public String getMoLastname() {
		return moLastname;
	}
	public void setMoLastname(String moLastname) {
		this.moLastname = moLastname;
	}
	public String getMoGender() {
		return moGender;
	}
	public void setMoGender(String moGender) {
		this.moGender = moGender;
	}
	public String getMoDobf() {
		return moDobf;
	}
	public void setMoDobf(String moDobf) {
		this.moDobf = moDobf;
	}
	public String getMoNationality() {
		return moNationality;
	}
	public void setMoNationality(String moNationality) {
		this.moNationality = moNationality;
	}
	public String getMoQualification() {
		return moQualification;
	}
	public void setMoQualification(String moQualification) {
		this.moQualification = moQualification;
	}
	public Mother(int id, String mother, String userId, String moRelationship, String moFirstname, String moMiddlename,
			String moLastname, String moGender, String moDobf, String moNationality, String moQualification) {
		super();
		this.id = id;
		this.mother = mother;
		this.userId = userId;
		this.moRelationship = moRelationship;
		this.moFirstname = moFirstname;
		this.moMiddlename = moMiddlename;
		this.moLastname = moLastname;
		this.moGender = moGender;
		this.moDobf = moDobf;
		this.moNationality = moNationality;
		this.moQualification = moQualification;
	}
	public Mother() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Mother [id=" + id + ", mother=" + mother + ", userId=" + userId + ", moRelationship=" + moRelationship
				+ ", moFirstname=" + moFirstname + ", moMiddlename=" + moMiddlename + ", moLastname=" + moLastname
				+ ", moGender=" + moGender + ", moDobf=" + moDobf + ", moNationality=" + moNationality
				+ ", moQualification=" + moQualification + "]";
	}
}
