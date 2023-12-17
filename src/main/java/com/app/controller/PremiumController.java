package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dto.PremiumDto;
import com.app.entity.Premium;
import com.app.globalexception.NotFoundException;
import com.app.service.PremiumService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/premium")
public class PremiumController {

	// Logger for logging controller actions
	private static final Logger logger = LoggerFactory.getLogger(PremiumController.class);
	
	// Autowired service for handling premium operations
	@Autowired
	PremiumService service;
	
	/***************************************************************************************
	 * Endpoint for fetching all premiums.
	 * 
	 * @return List of all premiums
	 ***************************************************************************************/
	@GetMapping("/getAllPremiums")
	public List<Premium> getallpremiums()
	{
		logger.info("Fetching all premiums");
		return service.getAll();
	}
	
	/***************************************************************************************
	 * Endpoint for fetching a premium by ID.
	 * 
	 * @param premiumId The ID of the premium to fetch
	 * @return Optional containing the premium with the specified ID
	 * @throws NotFoundException if the premium ID is not found
	 ***************************************************************************************/
	@GetMapping("/getByPremiumId/{premiumId}")
	public Optional<Premium> getbyPremiumId(@PathVariable Long premiumId) throws NotFoundException
	{
		logger.info("Fetching premium by ID");
		return service.getPremiumById(premiumId);
	}
	
	/***************************************************************************************
	 * Endpoint for creating a new premium.
	 * 
	 * @param PolicyId The ID of the associated policy
	 * @param dto The PremiumDto object containing premium details
	 * @return ResponseEntity indicating the success of the creation and HTTP status code
	 * @throws NotFoundException if an issue occurs during premium creation
	 ***************************************************************************************/
	@PostMapping("/createPremium")
	public ResponseEntity<Premium> createPremium(@RequestParam Long PolicyId, @Valid @RequestBody PremiumDto dto) throws NotFoundException
	{
		logger.info("Creating premium");
		Premium pl=service.createPremium(PolicyId, dto);
		logger.warn("Invalid premium data received");
		return ResponseEntity.status(HttpStatus.CREATED).body(pl);
	}
	
	/***************************************************************************************
	 * Endpoint for updating a premium.
	 * 
	 * @param premiumId The ID of the premium to update
	 * @param dto The PremiumDto object containing updated premium details
	 * @return ResponseEntity indicating the success of the update and HTTP status code
	 * @throws NotFoundException if the premium ID is not found
	 ***************************************************************************************/
	@PutMapping("/updatePremium/{premiumId}")
	public ResponseEntity<Premium> updatingPremium(@PathVariable Long premiumId,@Valid @RequestBody PremiumDto dto) throws NotFoundException
	{
		logger.info("Updating premium with ID");
		Premium update=service.updatePremium(premiumId, dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(update);
	}
	
	/***************************************************************************************
	 * Endpoint for deleting a premium by ID.
	 * 
	 * @param premiumId The ID of the premium to delete
	 * @return ResponseEntity indicating the success of the deletion and HTTP status code
	 * @throws NotFoundException if the premium ID is not found
	 ***************************************************************************************/
	@DeleteMapping("/deletePremium/{premiumId}")
	public ResponseEntity<String> deletingId(@PathVariable Long premiumId) throws NotFoundException
	{
		logger.info("Deleting premium with ID");
		String delete=service.deletePremium(premiumId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(delete);
	}
}

