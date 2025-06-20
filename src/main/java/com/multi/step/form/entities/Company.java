package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userId;
	private String companyId;
	
	private String companyname;
	private String companytype;
	private String position;
	private String profile;
	private String salary;
	private String fromdate;
	private String enddate;
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
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanytype() {
		return companytype;
	}
	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public Company(int id, String userId, String companyId, String companyname, String companytype, String position,
			String profile, String salary, String fromdate, String enddate) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyId = companyId;
		this.companyname = companyname;
		this.companytype = companytype;
		this.position = position;
		this.profile = profile;
		this.salary = salary;
		this.fromdate = fromdate;
		this.enddate = enddate;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", userId=" + userId + ", companyId=" + companyId + ", companyname=" + companyname
				+ ", companytype=" + companytype + ", position=" + position + ", profile=" + profile + ", salary="
				+ salary + ", fromdate=" + fromdate + ", enddate=" + enddate + "]";
	}
}
