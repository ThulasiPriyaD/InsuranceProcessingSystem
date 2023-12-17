package com.app.dto;

import jakarta.validation.constraints.*;

public class UserDto {
	
	// Validation annotations for ensuring non-null, non-empty, and correct format values
	
	@NotBlank(message = "Username is required")
    @Size(min = 7, message = "Username should be at least 7 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid username format")
	private String userName;
	
	 @NotBlank(message = "Password is required")
	 @Size(min = 8, message = "Password should be at least 8 characters")
	 @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=.*[a-zA-Z0-9!@#$%^&+=-_*])(?!.*\\\\s).{8,}$",
	 message = "Invalid password format")
	private String password;
	
	
	@NotBlank(message="Mobile number is required")
	@Size(min=10,max=10, message ="Mobile number must be 10 numbers")
	@Pattern(regexp= "^[0-9]*$")
	private String mobNo;
	
	@Email(message="Please enter valid Email Id")
	private String emailId;

	/*************************************************************************************
     * Getter and setters for retrieving the fields.
     *************************************************************************************/
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	
	

}
