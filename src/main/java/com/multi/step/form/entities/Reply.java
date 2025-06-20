package com.multi.step.form.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Reply {

	@Id
	private String replyId;
	private String requestId;
	private String date;
	@Column(length = 2048)
	private String description;
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Reply(String replyId, String requestId, String date, String description) {
		super();
		this.replyId = replyId;
		this.requestId = requestId;
		this.date = date;
		this.description = description;
	}
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", requestId=" + requestId + ", date=" + date + ", description="
				+ description + "]";
	}
}
