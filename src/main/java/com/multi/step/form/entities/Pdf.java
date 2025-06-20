package com.multi.step.form.entities;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Pdf {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userId;
	private String filename;
	private String documentName;
	private String status;
	
	@Lob
	@Column(length = 100000000)
	private byte[] data;

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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Pdf(int id, String userId, String filename, String documentName, String status, byte[] data) {
		super();
		this.id = id;
		this.userId = userId;
		this.filename = filename;
		this.documentName = documentName;
		this.status = status;
		this.data = data;
	}

	public Pdf() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pdf [id=" + id + ", userId=" + userId + ", filename=" + filename + ", documentName=" + documentName
				+ ", status=" + status + ", data=" + Arrays.toString(data) + "]";
	}
}
