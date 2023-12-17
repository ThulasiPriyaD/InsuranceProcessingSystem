package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dto.ClaimDto;
import com.app.entity.Claim;
import com.app.globalexception.NotFoundException;
import com.app.service.ClaimService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/api/claim")
public class ClaimController {

	 // Logger for logging controller actions
	private static final Logger logger = LoggerFactory.getLogger(ClaimController.class);
	
	// Autowired service for handling claim operations
	@Autowired
	ClaimService claimService;
	
	/***************************************************************************************
	 * Endpoint for creating a new claim.
	 * 
	 * @param policyId The ID of the associated policy
	 * @param PolicyHolderId The ID of the associated policy holder
	 * @param adminId The ID of the associated admin
	 * @param clmdto The ClaimDto object containing claim details
	 * @return ResponseEntity indicating the success of the creation and HTTP status code
	 * @throws NotFoundException if an issue occurs during claim creation
	 ***************************************************************************************/
	@PostMapping("/createClaim")
	public ResponseEntity<Claim> createClm(@RequestParam Long policyId,@RequestParam Long PolicyHolderId,@RequestParam Integer adminId,  @Valid @RequestBody ClaimDto clmdto) throws NotFoundException
	{
		logger.info("Creating claim");
		Claim ctrateClaim=claimService.createCalimUser(policyId, PolicyHolderId, adminId, clmdto);
		logger.warn("Invalid claim data received");
		return ResponseEntity.status(HttpStatus.CREATED).body(ctrateClaim);
	}
	
	/***************************************************************************************
	 * Endpoint for fetching all claims.
	 * 
	 * @return List of all claims
	 ***************************************************************************************/
	@GetMapping("/getAllClaim")
	public List<Claim> getAllClaim()
	{
		logger.info("Fetching all claims");
		return claimService.getAllClaims();
	}
	
	/***************************************************************************************
	 * Endpoint for fetching a claim by ID.
	 * 
	 * @param claimId The ID of the claim to fetch
	 * @return Optional containing the claim with the specified ID
	 ***************************************************************************************/
	@GetMapping("/getByClaimId/{claimId}")
	public Optional<Claim> getById(@PathVariable Long claimId)
	{
		logger.info("Fetching claim by ID");
		return claimService.getClaimById(claimId);
	}
	
	/***************************************************************************************
	 * Endpoint for deleting a claim by ID.
	 * 
	 * @param claimId The ID of the claim to delete
	 * @return ResponseEntity indicating the success of the deletion and HTTP status code
	 * @throws NotFoundException if the claim ID is not found
	 ***************************************************************************************/
	@DeleteMapping("/deleteClaim/{claimId}")
	public ResponseEntity<String> deleteByClaim(@PathVariable Long claimId) throws NotFoundException
	{
		logger.info("Deleting claim with ID");
		String deleteClaim=claimService.deletebyId(claimId);
		return ResponseEntity.status(HttpStatus.CREATED).body(deleteClaim);
	}
	
	/***************************************************************************************
	 * Endpoint for updating a claim.
	 * 
	 * @param claimId The ID of the claim to update
	 * @param status The new status for the claim
	 * @param amount The new amount for the claim
	 * @return ResponseEntity indicating the success of the update and HTTP status code
	 * @throws NotFoundException if the claim ID is not found
	 ***************************************************************************************/

	@PutMapping("/updateClaim/{claimId}")
	public ResponseEntity<String> updateInClaim(@PathVariable Long claimId,@RequestParam String status,@RequestParam double amount) throws NotFoundException
	{
		logger.info("Updating claim with ID");
		String updateClaim=claimService.updteClaim(claimId, status, amount);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateClaim);
	}
}
