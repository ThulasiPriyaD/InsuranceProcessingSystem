package com.app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "policyholder_insurance")
public class PolicyHolder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    
    /*************************************************************************************
     * Constructor with parameters for creating a new PolicyHolder instance.
     * 
     * @param firstName The first name of the policy holder
     * @param lastName The last name of the policy holder
     * @param address The address of the policy holder
     * @param email The email of the policy holder
     * @param phoneNumber The phone number of the policy holder
     *************************************************************************************/
	public PolicyHolder(String firstName, String lastName, String address, String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	/*************************************************************************************
     * Default constructor for PolicyHolder entity.
     *************************************************************************************/
	public PolicyHolder() {
	}
	
	/*************************************************************************************
     * Getters and setters for retrieving the fields of the policy holder.
    
     *************************************************************************************/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
