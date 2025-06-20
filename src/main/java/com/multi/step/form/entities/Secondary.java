package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Secondary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userId;
	
	private String secondary;
	private String secdegree;
	private String secduration;
	private String secstartdate;
	private String secenddate;
	private String secschool;
	private String secboard;
	private String secbranch;
	private String sectotalscore;
	private String sectotalmarks;
	private String secpercentage;
	private String secschoolstate;
	private String secschoolcity;
	private String secsubject1name;
	private String secsubject1marks;
	private String secsubject2name;
	private String secsubject2marks;
	private String secsubject3name;
	private String secsubject3marks;
	private String secsubject4name;
	private String secsubject4marks;
	private String secsubject5name;
	private String secsubject5marks;
	private String secsubject6name;
	private String secsubject6marks;
	private String secsubject7name;
	private String secsubject7marks;
	private String secsubject8name;
	private String secsubject8marks;
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
	public String getSecondary() {
		return secondary;
	}
	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}
	public String getSecdegree() {
		return secdegree;
	}
	public void setSecdegree(String secdegree) {
		this.secdegree = secdegree;
	}
	public String getSecduration() {
		return secduration;
	}
	public void setSecduration(String secduration) {
		this.secduration = secduration;
	}
	public String getSecstartdate() {
		return secstartdate;
	}
	public void setSecstartdate(String secstartdate) {
		this.secstartdate = secstartdate;
	}
	public String getSecenddate() {
		return secenddate;
	}
	public void setSecenddate(String secenddate) {
		this.secenddate = secenddate;
	}
	public String getSecschool() {
		return secschool;
	}
	public void setSecschool(String secschool) {
		this.secschool = secschool;
	}
	public String getSecboard() {
		return secboard;
	}
	public void setSecboard(String secboard) {
		this.secboard = secboard;
	}
	public String getSecbranch() {
		return secbranch;
	}
	public void setSecbranch(String secbranch) {
		this.secbranch = secbranch;
	}
	public String getSectotalscore() {
		return sectotalscore;
	}
	public void setSectotalscore(String sectotalscore) {
		this.sectotalscore = sectotalscore;
	}
	public String getSectotalmarks() {
		return sectotalmarks;
	}
	public void setSectotalmarks(String sectotalmarks) {
		this.sectotalmarks = sectotalmarks;
	}
	public String getSecpercentage() {
		return secpercentage;
	}
	public void setSecpercentage(String secpercentage) {
		this.secpercentage = secpercentage;
	}
	public String getSecschoolstate() {
		return secschoolstate;
	}
	public void setSecschoolstate(String secschoolstate) {
		this.secschoolstate = secschoolstate;
	}
	public String getSecschoolcity() {
		return secschoolcity;
	}
	public void setSecschoolcity(String secschoolcity) {
		this.secschoolcity = secschoolcity;
	}
	public String getSecsubject1name() {
		return secsubject1name;
	}
	public void setSecsubject1name(String secsubject1name) {
		this.secsubject1name = secsubject1name;
	}
	public String getSecsubject1marks() {
		return secsubject1marks;
	}
	public void setSecsubject1marks(String secsubject1marks) {
		this.secsubject1marks = secsubject1marks;
	}
	public String getSecsubject2name() {
		return secsubject2name;
	}
	public void setSecsubject2name(String secsubject2name) {
		this.secsubject2name = secsubject2name;
	}
	public String getSecsubject2marks() {
		return secsubject2marks;
	}
	public void setSecsubject2marks(String secsubject2marks) {
		this.secsubject2marks = secsubject2marks;
	}
	public String getSecsubject3name() {
		return secsubject3name;
	}
	public void setSecsubject3name(String secsubject3name) {
		this.secsubject3name = secsubject3name;
	}
	public String getSecsubject3marks() {
		return secsubject3marks;
	}
	public void setSecsubject3marks(String secsubject3marks) {
		this.secsubject3marks = secsubject3marks;
	}
	public String getSecsubject4name() {
		return secsubject4name;
	}
	public void setSecsubject4name(String secsubject4name) {
		this.secsubject4name = secsubject4name;
	}
	public String getSecsubject4marks() {
		return secsubject4marks;
	}
	public void setSecsubject4marks(String secsubject4marks) {
		this.secsubject4marks = secsubject4marks;
	}
	public String getSecsubject5name() {
		return secsubject5name;
	}
	public void setSecsubject5name(String secsubject5name) {
		this.secsubject5name = secsubject5name;
	}
	public String getSecsubject5marks() {
		return secsubject5marks;
	}
	public void setSecsubject5marks(String secsubject5marks) {
		this.secsubject5marks = secsubject5marks;
	}
	public String getSecsubject6name() {
		return secsubject6name;
	}
	public void setSecsubject6name(String secsubject6name) {
		this.secsubject6name = secsubject6name;
	}
	public String getSecsubject6marks() {
		return secsubject6marks;
	}
	public void setSecsubject6marks(String secsubject6marks) {
		this.secsubject6marks = secsubject6marks;
	}
	public String getSecsubject7name() {
		return secsubject7name;
	}
	public void setSecsubject7name(String secsubject7name) {
		this.secsubject7name = secsubject7name;
	}
	public String getSecsubject7marks() {
		return secsubject7marks;
	}
	public void setSecsubject7marks(String secsubject7marks) {
		this.secsubject7marks = secsubject7marks;
	}
	public String getSecsubject8name() {
		return secsubject8name;
	}
	public void setSecsubject8name(String secsubject8name) {
		this.secsubject8name = secsubject8name;
	}
	public String getSecsubject8marks() {
		return secsubject8marks;
	}
	public void setSecsubject8marks(String secsubject8marks) {
		this.secsubject8marks = secsubject8marks;
	}
	public Secondary(int id, String userId, String secondary, String secdegree, String secduration, String secstartdate,
			String secenddate, String secschool, String secboard, String secbranch, String sectotalscore,
			String sectotalmarks, String secpercentage, String secschoolstate, String secschoolcity,
			String secsubject1name, String secsubject1marks, String secsubject2name, String secsubject2marks,
			String secsubject3name, String secsubject3marks, String secsubject4name, String secsubject4marks,
			String secsubject5name, String secsubject5marks, String secsubject6name, String secsubject6marks,
			String secsubject7name, String secsubject7marks, String secsubject8name, String secsubject8marks) {
		super();
		this.id = id;
		this.userId = userId;
		this.secondary = secondary;
		this.secdegree = secdegree;
		this.secduration = secduration;
		this.secstartdate = secstartdate;
		this.secenddate = secenddate;
		this.secschool = secschool;
		this.secboard = secboard;
		this.secbranch = secbranch;
		this.sectotalscore = sectotalscore;
		this.sectotalmarks = sectotalmarks;
		this.secpercentage = secpercentage;
		this.secschoolstate = secschoolstate;
		this.secschoolcity = secschoolcity;
		this.secsubject1name = secsubject1name;
		this.secsubject1marks = secsubject1marks;
		this.secsubject2name = secsubject2name;
		this.secsubject2marks = secsubject2marks;
		this.secsubject3name = secsubject3name;
		this.secsubject3marks = secsubject3marks;
		this.secsubject4name = secsubject4name;
		this.secsubject4marks = secsubject4marks;
		this.secsubject5name = secsubject5name;
		this.secsubject5marks = secsubject5marks;
		this.secsubject6name = secsubject6name;
		this.secsubject6marks = secsubject6marks;
		this.secsubject7name = secsubject7name;
		this.secsubject7marks = secsubject7marks;
		this.secsubject8name = secsubject8name;
		this.secsubject8marks = secsubject8marks;
	}
	public Secondary() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Secondary [id=" + id + ", userId=" + userId + ", secondary=" + secondary + ", secdegree=" + secdegree
				+ ", secduration=" + secduration + ", secstartdate=" + secstartdate + ", secenddate=" + secenddate
				+ ", secschool=" + secschool + ", secboard=" + secboard + ", secbranch=" + secbranch
				+ ", sectotalscore=" + sectotalscore + ", sectotalmarks=" + sectotalmarks + ", secpercentage="
				+ secpercentage + ", secschoolstate=" + secschoolstate + ", secschoolcity=" + secschoolcity
				+ ", secsubject1name=" + secsubject1name + ", secsubject1marks=" + secsubject1marks
				+ ", secsubject2name=" + secsubject2name + ", secsubject2marks=" + secsubject2marks
				+ ", secsubject3name=" + secsubject3name + ", secsubject3marks=" + secsubject3marks
				+ ", secsubject4name=" + secsubject4name + ", secsubject4marks=" + secsubject4marks
				+ ", secsubject5name=" + secsubject5name + ", secsubject5marks=" + secsubject5marks
				+ ", secsubject6name=" + secsubject6name + ", secsubject6marks=" + secsubject6marks
				+ ", secsubject7name=" + secsubject7name + ", secsubject7marks=" + secsubject7marks
				+ ", secsubject8name=" + secsubject8name + ", secsubject8marks=" + secsubject8marks + "]";
	}
}
