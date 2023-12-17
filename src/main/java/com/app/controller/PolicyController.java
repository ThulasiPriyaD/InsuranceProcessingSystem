package com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.app.service.PolicyService;

import jakarta.validation.Valid;

import java.util.*;

import com.app.dto.policyDto;
import com.app.entity.*;
import com.app.globalexception.NotFoundException;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {

	// Logger for logging controller actions
	private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);
	
	// Autowired service for handling policy operations
	@Autowired
	PolicyService policyservice;
	
	/***************************************************************************************
	 * Endpoint for fetching all policies.
	 * 
	 * @return List of all policies
	 ***************************************************************************************/
	@GetMapping("/getAllPolicies")
	public List<Policy> allpolicies()
	{
		logger.info("Fetching all policies");
		return policyservice.getAllPolicys();
	}
	
	/***************************************************************************************
	 * Endpoint for fetching a policy by ID.
	 * 
	 * @param policyId The ID of the policy to fetch
	 * @return Optional containing the policy with the specified ID
	 ***************************************************************************************/
	@GetMapping("getByPolicyId/{policyId}")
	public Optional<Policy> getbypolicyId(@PathVariable Long policyId)
	{
		logger.info("Fetching policy by ID");
		return policyservice.getpolicy(policyId);
	}
	
	/***************************************************************************************
	 * Endpoint for creating a new policy.
	 * 
	 * @param policyHolderId The ID of the associated policy holder
	 * @param dto The policyDto object containing policy details
	 * @return ResponseEntity indicating the success of the creation and HTTP status code
	 * @throws NotFoundException if an issue occurs during policy creation
	 ***************************************************************************************/
	@PostMapping("/createPolicy/{policyHolderId}")
	public ResponseEntity<Policy> createPolicies(@PathVariable Long policyHolderId,@Valid @RequestBody policyDto dto) throws NotFoundException
	{
		logger.info("Creating policy");
		Policy ctreatePolicy=policyservice.createPolicy(policyHolderId,dto);
		logger.warn("Invalid policy data received");
		return ResponseEntity.status(HttpStatus.CREATED).body(ctreatePolicy);
	}
	
	/***************************************************************************************
	 * Endpoint for updating a policy.
	 * 
	 * @param policyId The ID of the policy to update
	 * @param name The new name for the policy
	 * @param type The new type for the policy
	 * @return ResponseEntity indicating the success of the update and HTTP status code
	 * @throws NotFoundException if the policy ID is not found
	 ***************************************************************************************/
	@PutMapping("/updatePolicy/{policyId}")
	public ResponseEntity<String> updatePolicy(@PathVariable Long policyId,@Valid @RequestParam String name,@RequestParam String type) throws NotFoundException
	{
		logger.info("Updating policy with ID");
		String updated=policyservice.updateInId(policyId, name, type);
		return ResponseEntity.status(HttpStatus.CREATED).body(updated);
	}
	
	/***************************************************************************************
	 * Endpoint for deleting a policy by ID.
	 * 
	 * @param policyId The ID of the policy to delete
	 * @return ResponseEntity indicating the success of the deletion and HTTP status code
	 * @throws NotFoundException if the policy ID is not found
	 ***************************************************************************************/
	@DeleteMapping("/deletePolicy/{policyId}")
	public ResponseEntity<String> deletePolicy(@PathVariable Long policyId) throws NotFoundException
	{
		logger.info("Deleting policy with ID");
		String deleted=policyservice.deletePolId(policyId);
		return ResponseEntity.status(HttpStatus.CREATED).body(deleted);
	}
}
