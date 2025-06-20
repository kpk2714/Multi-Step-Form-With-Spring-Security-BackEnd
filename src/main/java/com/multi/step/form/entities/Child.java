package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String child;
	private String userId;
	private String childRelationship;
	private String childFirstname;
	private String childMiddlename;
	private String childLastname;
	private String childGender;
	private String childDobf;
	private String childNationality;
	private String childQualification;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChildRelationship() {
		return childRelationship;
	}
	public void setChildRelationship(String childRelationship) {
		this.childRelationship = childRelationship;
	}
	public String getChildFirstname() {
		return childFirstname;
	}
	public void setChildFirstname(String childFirstname) {
		this.childFirstname = childFirstname;
	}
	public String getChildMiddlename() {
		return childMiddlename;
	}
	public void setChildMiddlename(String childMiddlename) {
		this.childMiddlename = childMiddlename;
	}
	public String getChildLastname() {
		return childLastname;
	}
	public void setChildLastname(String childLastname) {
		this.childLastname = childLastname;
	}
	public String getChildGender() {
		return childGender;
	}
	public void setChildGender(String childGender) {
		this.childGender = childGender;
	}
	public String getChildDobf() {
		return childDobf;
	}
	public void setChildDobf(String childDobf) {
		this.childDobf = childDobf;
	}
	public String getChildNationality() {
		return childNationality;
	}
	public void setChildNationality(String childNationality) {
		this.childNationality = childNationality;
	}
	public String getChildQualification() {
		return childQualification;
	}
	public void setChildQualification(String childQualification) {
		this.childQualification = childQualification;
	}
	public Child(int id, String child, String userId, String childRelationship, String childFirstname,
			String childMiddlename, String childLastname, String childGender, String childDobf, String childNationality,
			String childQualification) {
		super();
		this.id = id;
		this.child = child;
		this.userId = userId;
		this.childRelationship = childRelationship;
		this.childFirstname = childFirstname;
		this.childMiddlename = childMiddlename;
		this.childLastname = childLastname;
		this.childGender = childGender;
		this.childDobf = childDobf;
		this.childNationality = childNationality;
		this.childQualification = childQualification;
	}
	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Child [id=" + id + ", child=" + child + ", userId=" + userId + ", childRelationship="
				+ childRelationship + ", childFirstname=" + childFirstname + ", childMiddlename=" + childMiddlename
				+ ", childLastname=" + childLastname + ", childGender=" + childGender + ", childDobf=" + childDobf
				+ ", childNationality=" + childNationality + ", childQualification=" + childQualification + "]";
	}
}
