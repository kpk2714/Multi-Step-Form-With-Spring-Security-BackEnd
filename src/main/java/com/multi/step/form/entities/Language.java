package com.multi.step.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userId;
	private String languageId;
	private String languageType;
	private String languageCode;
	private String isRead;
	private String isWrite;
	private String isSpeak;
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
	public String getLanguageId() {
		return languageId;
	}
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	public String getLanguageType() {
		return languageType;
	}
	public void setLanguageType(String languageType) {
		this.languageType = languageType;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	public String getIsWrite() {
		return isWrite;
	}
	public void setIsWrite(String isWrite) {
		this.isWrite = isWrite;
	}
	public String getIsSpeak() {
		return isSpeak;
	}
	public void setIsSpeak(String isSpeak) {
		this.isSpeak = isSpeak;
	}
	public Language(int id, String userId, String languageId, String languageType, String languageCode, String isRead,
			String isWrite, String isSpeak) {
		super();
		this.id = id;
		this.userId = userId;
		this.languageId = languageId;
		this.languageType = languageType;
		this.languageCode = languageCode;
		this.isRead = isRead;
		this.isWrite = isWrite;
		this.isSpeak = isSpeak;
	}
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Language [id=" + id + ", userId=" + userId + ", languageId=" + languageId + ", languageType="
				+ languageType + ", languageCode=" + languageCode + ", isRead=" + isRead + ", isWrite=" + isWrite
				+ ", isSpeak=" + isSpeak + "]";
	}
	
	
}
