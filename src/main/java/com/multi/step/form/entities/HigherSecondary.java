package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HigherSecondary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userId;
	
	private String highersecondary;
	private String highsecdegree;
	private String highsecduration;
	private String highsecstartdate;
	private String highsecenddate;
	private String highsecschool;
	private String highsecboard;
	private String highsecbranch;
	private String highsectotalscore;
	private String highsectotalmarks;
	private String highsecpercentage;
	private String highsecschoolstate;
	private String highsecschoolcity;
	private String highsecsubject1name;
	private String highsecsubject1marks;
	private String highsecsubject2name;
	private String highsecsubject2marks;
	private String highsecsubject3name;
	private String highsecsubject3marks;
	private String highsecsubject4name;
	private String highsecsubject4marks;
	private String highsecsubject5name;
	private String highsecsubject5marks;
	private String highsecsubject6name;
	private String highsecsubject6marks;
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
	public String getHighersecondary() {
		return highersecondary;
	}
	public void setHighersecondary(String highersecondary) {
		this.highersecondary = highersecondary;
	}
	public String getHighsecdegree() {
		return highsecdegree;
	}
	public void setHighsecdegree(String highsecdegree) {
		this.highsecdegree = highsecdegree;
	}
	public String getHighsecduration() {
		return highsecduration;
	}
	public void setHighsecduration(String highsecduration) {
		this.highsecduration = highsecduration;
	}
	public String getHighsecstartdate() {
		return highsecstartdate;
	}
	public void setHighsecstartdate(String highsecstartdate) {
		this.highsecstartdate = highsecstartdate;
	}
	public String getHighsecenddate() {
		return highsecenddate;
	}
	public void setHighsecenddate(String highsecenddate) {
		this.highsecenddate = highsecenddate;
	}
	public String getHighsecschool() {
		return highsecschool;
	}
	public void setHighsecschool(String highsecschool) {
		this.highsecschool = highsecschool;
	}
	public String getHighsecboard() {
		return highsecboard;
	}
	public void setHighsecboard(String highsecboard) {
		this.highsecboard = highsecboard;
	}
	public String getHighsecbranch() {
		return highsecbranch;
	}
	public void setHighsecbranch(String highsecbranch) {
		this.highsecbranch = highsecbranch;
	}
	public String getHighsectotalscore() {
		return highsectotalscore;
	}
	public void setHighsectotalscore(String highsectotalscore) {
		this.highsectotalscore = highsectotalscore;
	}
	public String getHighsectotalmarks() {
		return highsectotalmarks;
	}
	public void setHighsectotalmarks(String highsectotalmarks) {
		this.highsectotalmarks = highsectotalmarks;
	}
	public String getHighsecpercentage() {
		return highsecpercentage;
	}
	public void setHighsecpercentage(String highsecpercentage) {
		this.highsecpercentage = highsecpercentage;
	}
	public String getHighsecschoolstate() {
		return highsecschoolstate;
	}
	public void setHighsecschoolstate(String highsecschoolstate) {
		this.highsecschoolstate = highsecschoolstate;
	}
	public String getHighsecschoolcity() {
		return highsecschoolcity;
	}
	public void setHighsecschoolcity(String highsecschoolcity) {
		this.highsecschoolcity = highsecschoolcity;
	}
	public String getHighsecsubject1name() {
		return highsecsubject1name;
	}
	public void setHighsecsubject1name(String highsecsubject1name) {
		this.highsecsubject1name = highsecsubject1name;
	}
	public String getHighsecsubject1marks() {
		return highsecsubject1marks;
	}
	public void setHighsecsubject1marks(String highsecsubject1marks) {
		this.highsecsubject1marks = highsecsubject1marks;
	}
	public String getHighsecsubject2name() {
		return highsecsubject2name;
	}
	public void setHighsecsubject2name(String highsecsubject2name) {
		this.highsecsubject2name = highsecsubject2name;
	}
	public String getHighsecsubject2marks() {
		return highsecsubject2marks;
	}
	public void setHighsecsubject2marks(String highsecsubject2marks) {
		this.highsecsubject2marks = highsecsubject2marks;
	}
	public String getHighsecsubject3name() {
		return highsecsubject3name;
	}
	public void setHighsecsubject3name(String highsecsubject3name) {
		this.highsecsubject3name = highsecsubject3name;
	}
	public String getHighsecsubject3marks() {
		return highsecsubject3marks;
	}
	public void setHighsecsubject3marks(String highsecsubject3marks) {
		this.highsecsubject3marks = highsecsubject3marks;
	}
	public String getHighsecsubject4name() {
		return highsecsubject4name;
	}
	public void setHighsecsubject4name(String highsecsubject4name) {
		this.highsecsubject4name = highsecsubject4name;
	}
	public String getHighsecsubject4marks() {
		return highsecsubject4marks;
	}
	public void setHighsecsubject4marks(String highsecsubject4marks) {
		this.highsecsubject4marks = highsecsubject4marks;
	}
	public String getHighsecsubject5name() {
		return highsecsubject5name;
	}
	public void setHighsecsubject5name(String highsecsubject5name) {
		this.highsecsubject5name = highsecsubject5name;
	}
	public String getHighsecsubject5marks() {
		return highsecsubject5marks;
	}
	public void setHighsecsubject5marks(String highsecsubject5marks) {
		this.highsecsubject5marks = highsecsubject5marks;
	}
	public String getHighsecsubject6name() {
		return highsecsubject6name;
	}
	public void setHighsecsubject6name(String highsecsubject6name) {
		this.highsecsubject6name = highsecsubject6name;
	}
	public String getHighsecsubject6marks() {
		return highsecsubject6marks;
	}
	public void setHighsecsubject6marks(String highsecsubject6marks) {
		this.highsecsubject6marks = highsecsubject6marks;
	}
	public HigherSecondary(int id, String userId, String highersecondary, String highsecdegree, String highsecduration,
			String highsecstartdate, String highsecenddate, String highsecschool, String highsecboard,
			String highsecbranch, String highsectotalscore, String highsectotalmarks, String highsecpercentage,
			String highsecschoolstate, String highsecschoolcity, String highsecsubject1name,
			String highsecsubject1marks, String highsecsubject2name, String highsecsubject2marks,
			String highsecsubject3name, String highsecsubject3marks, String highsecsubject4name,
			String highsecsubject4marks, String highsecsubject5name, String highsecsubject5marks,
			String highsecsubject6name, String highsecsubject6marks) {
		super();
		this.id = id;
		this.userId = userId;
		this.highersecondary = highersecondary;
		this.highsecdegree = highsecdegree;
		this.highsecduration = highsecduration;
		this.highsecstartdate = highsecstartdate;
		this.highsecenddate = highsecenddate;
		this.highsecschool = highsecschool;
		this.highsecboard = highsecboard;
		this.highsecbranch = highsecbranch;
		this.highsectotalscore = highsectotalscore;
		this.highsectotalmarks = highsectotalmarks;
		this.highsecpercentage = highsecpercentage;
		this.highsecschoolstate = highsecschoolstate;
		this.highsecschoolcity = highsecschoolcity;
		this.highsecsubject1name = highsecsubject1name;
		this.highsecsubject1marks = highsecsubject1marks;
		this.highsecsubject2name = highsecsubject2name;
		this.highsecsubject2marks = highsecsubject2marks;
		this.highsecsubject3name = highsecsubject3name;
		this.highsecsubject3marks = highsecsubject3marks;
		this.highsecsubject4name = highsecsubject4name;
		this.highsecsubject4marks = highsecsubject4marks;
		this.highsecsubject5name = highsecsubject5name;
		this.highsecsubject5marks = highsecsubject5marks;
		this.highsecsubject6name = highsecsubject6name;
		this.highsecsubject6marks = highsecsubject6marks;
	}
	public HigherSecondary() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HigherSecondary [id=" + id + ", userId=" + userId + ", highersecondary=" + highersecondary
				+ ", highsecdegree=" + highsecdegree + ", highsecduration=" + highsecduration + ", highsecstartdate="
				+ highsecstartdate + ", highsecenddate=" + highsecenddate + ", highsecschool=" + highsecschool
				+ ", highsecboard=" + highsecboard + ", highsecbranch=" + highsecbranch + ", highsectotalscore="
				+ highsectotalscore + ", highsectotalmarks=" + highsectotalmarks + ", highsecpercentage="
				+ highsecpercentage + ", highsecschoolstate=" + highsecschoolstate + ", highsecschoolcity="
				+ highsecschoolcity + ", highsecsubject1name=" + highsecsubject1name + ", highsecsubject1marks="
				+ highsecsubject1marks + ", highsecsubject2name=" + highsecsubject2name + ", highsecsubject2marks="
				+ highsecsubject2marks + ", highsecsubject3name=" + highsecsubject3name + ", highsecsubject3marks="
				+ highsecsubject3marks + ", highsecsubject4name=" + highsecsubject4name + ", highsecsubject4marks="
				+ highsecsubject4marks + ", highsecsubject5name=" + highsecsubject5name + ", highsecsubject5marks="
				+ highsecsubject5marks + ", highsecsubject6name=" + highsecsubject6name + ", highsecsubject6marks="
				+ highsecsubject6marks + "]";
	}
}
