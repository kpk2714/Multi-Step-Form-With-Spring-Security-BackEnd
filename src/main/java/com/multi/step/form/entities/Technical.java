package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Technical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userId;
	private String skillId;
	private String certificationName;
	private String category;
	private String technicalSkills;
	private String institute;
	private String duration;
	private String certificateIsPresent;
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
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public String getCertificationName() {
		return certificationName;
	}
	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTechnicalSkills() {
		return technicalSkills;
	}
	public void setTechnicalSkills(String technicalSkills) {
		this.technicalSkills = technicalSkills;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCertificateIsPresent() {
		return certificateIsPresent;
	}
	public void setCertificateIsPresent(String certificateIsPresent) {
		this.certificateIsPresent = certificateIsPresent;
	}
	public Technical(int id, String userId, String skillId, String certificationName, String category,
			String technicalSkills, String institute, String duration, String certificateIsPresent) {
		super();
		this.id = id;
		this.userId = userId;
		this.skillId = skillId;
		this.certificationName = certificationName;
		this.category = category;
		this.technicalSkills = technicalSkills;
		this.institute = institute;
		this.duration = duration;
		this.certificateIsPresent = certificateIsPresent;
	}
	public Technical() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Technical [id=" + id + ", userId=" + userId + ", skillId=" + skillId + ", certificationName="
				+ certificationName + ", category=" + category + ", technicalSkills=" + technicalSkills + ", institute="
				+ institute + ", duration=" + duration + ", certificateIsPresent=" + certificateIsPresent + "]";
	}
}
