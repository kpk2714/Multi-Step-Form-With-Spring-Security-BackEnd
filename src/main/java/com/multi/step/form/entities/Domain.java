package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Domain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String companyDomain;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyDomain() {
		return companyDomain;
	}
	public void setCompanyDomain(String companyDomain) {
		this.companyDomain = companyDomain;
	}
	public Domain(int id, String companyDomain) {
		super();
		this.id = id;
		this.companyDomain = companyDomain;
	}
	public Domain() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Domain [id=" + id + ", companyDomain=" + companyDomain + "]";
	}
}
