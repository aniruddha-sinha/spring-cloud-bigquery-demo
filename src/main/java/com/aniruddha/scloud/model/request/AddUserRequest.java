package com.aniruddha.scloud.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddUserRequest {
	@JsonProperty("user-id")
	private Integer userId;
	@JsonProperty("user-name")
	private String userName;
	@JsonProperty("user-email")
	private String email;
	@JsonProperty("mobile-number")
	private String mobileNumber;
	@JsonProperty("fax-number")
	private String faxNumber;
	@JsonProperty("is-email-valid")
	private Boolean isEmailValid;
	@JsonProperty("is-mobile-valid")
	private Boolean isMobileValid;
	@JsonProperty("user-status")
	private String userStatus;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public Boolean getIsEmailValid() {
		return isEmailValid;
	}

	public void setIsEmailValid(Boolean isEmailValid) {
		this.isEmailValid = isEmailValid;
	}

	public Boolean getIsMobileValid() {
		return isMobileValid;
	}

	public void setIsMobileValid(Boolean isMobileValid) {
		this.isMobileValid = isMobileValid;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}
