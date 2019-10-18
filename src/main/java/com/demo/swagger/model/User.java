package com.demo.swagger.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

@ApiModel(value = "User", description = "used to hold user details", parent = Object.class, discriminator = "user details")
public class User {
	@ApiModelProperty(name = "userId", dataType = "long", required = false, position = 1, allowEmptyValue = true, example = "123456", accessMode = AccessMode.READ_ONLY, hidden = true)
	@JsonProperty(value = "userId", required = false)
	private Long userId;
	@ApiModelProperty(name = "firstName", dataType = "string", required = true, position = 2, allowEmptyValue = false, example = "Suresh", accessMode = AccessMode.AUTO, hidden = false)
	@JsonProperty(value = "firstName", required = true)
	private String firstName;
	@ApiModelProperty(name = "lastName", dataType = "string", required = true, position = 3, allowEmptyValue = false, example = "E", accessMode = AccessMode.READ_WRITE, notes = "User Lastname", hidden = false)
	@JsonProperty(value = "lastName", required = true)
	@NotNull(message = "Last name is required")
	private String lastName;
	@ApiModelProperty(name = "phoneNumber", dataType = "string", required = true, position = 4, example = "8125743669", accessMode = AccessMode.READ_WRITE, notes = "For conatcting user need phone number", hidden = false)
	@JsonProperty(value = "phoneNumber", required = true)
	@NotNull(message = "Phone Number is required")
	private String phoneNumber;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=").append(userId).append(", firstName=").append(firstName).append(", lastName=")
				.append(lastName).append(", phoneNumber=").append(phoneNumber).append("]");
		return builder.toString();
	}
}
