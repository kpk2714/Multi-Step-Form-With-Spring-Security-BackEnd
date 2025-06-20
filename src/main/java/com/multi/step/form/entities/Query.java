package com.multi.step.form.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Query {

	@Id
	private String id;
	private String userId;
	private String category;
	private String status;
	private String description;
	private String queryDate;
	private Date queryTime;
	private String action;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}
	public Date getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(Date queryTime) {
		this.queryTime = queryTime;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Query(String id, String userId, String category, String status, String description, String queryDate,
			Date queryTime, String action) {
		super();
		this.id = id;
		this.userId = userId;
		this.category = category;
		this.status = status;
		this.description = description;
		this.queryDate = queryDate;
		this.queryTime = queryTime;
		this.action = action;
	}
	public Query() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Query [id=" + id + ", userId=" + userId + ", category=" + category + ", status=" + status
				+ ", description=" + description + ", queryDate=" + queryDate + ", queryTime=" + queryTime + ", action="
				+ action + "]";
	}
}
