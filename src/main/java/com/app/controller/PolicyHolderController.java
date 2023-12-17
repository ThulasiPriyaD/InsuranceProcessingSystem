package com.app.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dto.PolicyHolderDto;
import com.app.entity.PolicyHolder;
import com.app.globalexception.NotFoundException;
import com.app.service.PolicyHolderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/policyHolders")
public class PolicyHolderController {
	
	/*
	 * Policy holder Update
	 * {
		  "firstName": "string",
		  "lastName": "string",
		  "address": "string",
		  "email": "string",
		  "phoneNumber": "stringstri"
		}*/
	
		/*
		 * {
  			"firstName": "string",
  			"lastName": "string",
  			"address": "string",
  			"email": "string",
  			"phoneNumber": "stringstri"
			}
		 */

	// Logger for logging controller actions
	private static final Logger logger = LoggerFactory.getLogger(PolicyHolderController.class);
	
	// Autowired service for handling policy holder operations
	@Autowired
	private PolicyHolderService service;
	
	/***************************************************************************************
	 * Retrieves all policy holders.
	 * 
	 * @return List of PolicyHolders
	 ***************************************************************************************/
	@GetMapping("/getAllPolicyHolders")
	public List<PolicyHolder> getAllPolicyHolder(){
		
		logger.info("Fetching all policy holders");
		return service.getAllPolicyHolders();
		
	}
	
	/***************************************************************************************
	 * Retrieves a specific policy holder by ID.
	 * 
	 * @param policyHolderId The ID of the PolicyHolder to retrieve
	 * @return Optional containing the PolicyHolder, or an empty Optional if not found
	 ***************************************************************************************/
	
	@GetMapping("/getByPolicyHolderId/{policyHolderId}")
	public Optional<PolicyHolder> getPolicyHolderById(@PathVariable Long policyHolderId){
		logger.info("Fetching policy holder by ID:");
		return service.getPolicyHolderById(policyHolderId);
		
	}
	
	/***************************************************************************************
	 * Creates a new policy holder based on the provided PolicyHolderDto.
	 * 
	 * @param policyholderdto The PolicyHolderDto containing information for the new PolicyHolder
	 * @return ResponseEntity containing the created PolicyHolder and HTTP status code
	 * @throws NotFoundException if the email or phone number already exists
	 ***************************************************************************************/
	@PostMapping("/createPolicyHolder")
	public ResponseEntity<PolicyHolder> createPolicyHolder(@Valid @RequestBody PolicyHolderDto policyholderdto) throws NotFoundException 
	{
		logger.info("Creating policy holders");
		PolicyHolder pl =service.createPolicyHolder(policyholderdto);
		logger.info("Creating user:");
		return ResponseEntity.status(HttpStatus.CREATED).body(pl);
		
	}
	
	/***************************************************************************************
	 * Updates an existing policy holder with the provided information.
	 * 
	 * @param policyHolderId The ID of the PolicyHolder to update
	 * @param dto The PolicyHolderDto containing updated information
	 * @return ResponseEntity containing a message indicating the success of the update and HTTP status code
	 * @throws NotFoundException if the PolicyHolder ID is not found or if the new phone number already exists
	 ***************************************************************************************/
	@PutMapping("/updatePolicyHolder/{PolicyHolderId}")
	public ResponseEntity<String> updatedPolicyHolder(@PathVariable Long PolicyHolderId, @Valid @RequestBody PolicyHolderDto dto) throws NotFoundException
	{
		logger.info("Updating policy holder with ID");
		String updated=service.updatePolicyHol(PolicyHolderId, dto);
		logger.warn("Invalid user data received");
		return ResponseEntity.status(HttpStatus.CREATED).body(updated);
	}
	
	/***************************************************************************************
	 * Deletes a policy holder with the specified ID.
	 * 
	 * @param PolicyHolderId The ID of the PolicyHolder to delete
	 * @return ResponseEntity containing a message indicating the success of the deletion and HTTP status code
	 * @throws NotFoundException if the PolicyHolder ID is not found
	 ***************************************************************************************/
	@DeleteMapping("/deletePolicyHolder/{PolicyHolderId}")
	public ResponseEntity<String> deletedPolicyHolder(@PathVariable Long PolicyHolderId) throws NotFoundException
	{
		logger.info("Deleting user with ID");
		String delete=service.deletePolicyHolder(PolicyHolderId);
		logger.warn("Invalid user data received");
		return ResponseEntity.status(HttpStatus.CREATED).body(delete);
	}
}
