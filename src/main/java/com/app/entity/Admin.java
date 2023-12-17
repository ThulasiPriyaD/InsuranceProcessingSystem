package com.app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "admin_Insurance")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adminId;
	
	// Admin name validation
	@NotBlank(message = "Name Should not be Blank")
	@NotNull(message ="Username Should not be NUll")
	@Size(min=6, message="Length Should be 6 or Above")
	@Pattern(regexp ="^Admin(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{7,}$", message = "Type Correct pattern")
	private String adminname;
	
	 // Admin password validation
	@NotBlank(message = "Name Should not be Blank")
	@NotNull(message ="Password Should not be NUll")
	@Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=.*[a-zA-Z0-9!@#$%^&+=-_*])(?!.*\\s).{8,}$",
	message = " InCorrect pattern")
	private String password;
	

	//Default Constructor
	public Admin() {}
	
	// Constructor with parameters for creating a Admin object
	public Admin(int adminId, String adminname, String password)
	{
		this.adminId = adminId;
		this.adminname = adminname;
		this.password = password;
	}

	/*************************************************************************************
     * Getter and setters for retrieving the fields.
     *************************************************************************************/
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminname=" + adminname + ", password=" + password + "]";
	}
}
