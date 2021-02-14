package com.aniruddha.scloud.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInsertResponse {

	@JsonProperty("user-id")
	private Integer userId;

	@JsonProperty("user-email")
	private String email;

	@JsonProperty("entry-status")
	private String recordInsertionStatus;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRecordInsertionStatus() {
		return recordInsertionStatus;
	}

	public void setRecordInsertionStatus(String recordInsertionStatus) {
		this.recordInsertionStatus = recordInsertionStatus;
	}

}
