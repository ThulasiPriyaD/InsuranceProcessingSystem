package com.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user_Insurance")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String password;
	private String mobNo;
	private String emailId;
	
	//Default Constructor
	public User() {}
	
	// Constructor with parameters for creating a User object
	public User(String userName, String password, String mobNo, String emailId) {
		super();
		this.userName = userName;
		this.password = password;
		this.mobNo = mobNo;
		this.emailId = emailId;
	}

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
