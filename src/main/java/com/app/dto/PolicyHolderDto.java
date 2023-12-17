package com.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PolicyHolderDto {

	// Validation annotations for ensuring non-null, non-empty, and correct format values
	
	@NotBlank(message = "First name is required")
	@NotNull(message="First name should not be null")
    private String firstName;
 
    @NotBlank(message = "Last name is required")
    @NotNull(message="Last name should not be Null")
    private String lastName;
 
    @NotBlank(message = "Address is required")
    @NotNull(message="Address should not be null")
    private String address;
 
    @NotBlank(message = "Email is required")
    @Email(message="enter correct email address")
    private String email;
 
    @NotBlank(message = "Phone number is required")
    @Size(min=10,max=10,message="enter 10 digit mobile number")
    private String phoneNumber;

    
    /*************************************************************************************
     * Getter and setters for retrieving the fields.
     *************************************************************************************/
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    
}
