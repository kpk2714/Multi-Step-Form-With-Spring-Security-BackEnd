package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Father {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	private String father;
	private String userId;
	private String faRelationship;
	private String faFirstname;
	private String faMiddlename;
	private String faLastname;
	private String faGender;
	private String faDobf;
	private String faNationality;
	private String faQualification;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFaRelationship() {
		return faRelationship;
	}
	public void setFaRelationship(String faRelationship) {
		this.faRelationship = faRelationship;
	}
	public String getFaFirstname() {
		return faFirstname;
	}
	public void setFaFirstname(String faFirstname) {
		this.faFirstname = faFirstname;
	}
	public String getFaMiddlename() {
		return faMiddlename;
	}
	public void setFaMiddlename(String faMiddlename) {
		this.faMiddlename = faMiddlename;
	}
	public String getFaLastname() {
		return faLastname;
	}
	public void setFaLastname(String faLastname) {
		this.faLastname = faLastname;
	}
	public String getFaGender() {
		return faGender;
	}
	public void setFaGender(String faGender) {
		this.faGender = faGender;
	}
	public String getFaDobf() {
		return faDobf;
	}
	public void setFaDobf(String faDobf) {
		this.faDobf = faDobf;
	}
	public String getFaNationality() {
		return faNationality;
	}
	public void setFaNationality(String faNationality) {
		this.faNationality = faNationality;
	}
	public String getFaQualification() {
		return faQualification;
	}
	public void setFaQualification(String faQualification) {
		this.faQualification = faQualification;
	}
	public Father(int id, String father, String userId, String faRelationship, String faFirstname, String faMiddlename,
			String faLastname, String faGender, String faDobf, String faNationality, String faQualification) {
		super();
		this.id = id;
		this.father = father;
		this.userId = userId;
		this.faRelationship = faRelationship;
		this.faFirstname = faFirstname;
		this.faMiddlename = faMiddlename;
		this.faLastname = faLastname;
		this.faGender = faGender;
		this.faDobf = faDobf;
		this.faNationality = faNationality;
		this.faQualification = faQualification;
	}
	public Father() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Father [id=" + id + ", father=" + father + ", userId=" + userId + ", faRelationship=" + faRelationship
				+ ", faFirstname=" + faFirstname + ", faMiddlename=" + faMiddlename + ", faLastname=" + faLastname
				+ ", faGender=" + faGender + ", faDobf=" + faDobf + ", faNationality=" + faNationality
				+ ", faQualification=" + faQualification + "]";
	}
}
