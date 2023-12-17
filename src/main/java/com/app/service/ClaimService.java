package com.app.service;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dto.ClaimDto;
import com.app.entity.*;
import com.app.globalexception.NotFoundException;
import com.app.repository.*;
import jakarta.validation.Valid;
import java.util.*;

@Service
public class ClaimService
{
	@Autowired
	ClaimRepo claimrepo;
	
	@Autowired
	PolicyHolderRepo policyHolderRepo;
	
	@Autowired
	PolicyRepo policyRepo;
	
	AdminRepo adminrepo;
	
	/*******************************************************************************
	 * Retrieves all existing claims.
	 *
	 * @return List of all claims
	 *******************************************************************************/
	public List<Claim> getAllClaims()
	{
		return claimrepo.findAll();
	}
	
	/*********************************************************************************
	 * Retrieves a claim by its ID.
	 *
	 * @param claimId The ID of the claim to retrieve
	 * @return Optional containing the claim if found, else empty
	 **********************************************************************************/
	public Optional<Claim> getClaimById(Long claimId)
	{
		return claimrepo.findById(claimId);
	}
	
	/********************************************************************************
	 * Creates a new claim for a policy holder.
	 *
	 * @param PolicyId The ID of the associated policy
	 * @param PolicyHolderId The ID of the associated policy holder
	 * @param adminId The ID of the admin handling the claim
	 * @param clmDto The claim details
	 * @return The created claim
	 * @throws NotFoundException If the policy, policy holder, or admin is not found,
	 *                           or if the claim number already exists
	 ****************************************************************************************/
	public Claim createCalimUser( Long PolicyId,Long PolicyHolderId,Integer adminId,  @Valid ClaimDto clmDto) throws NotFoundException
	{
		
		Policy policy = policyRepo.findById(PolicyId)
				.orElseThrow(()-> new NotFoundException("Policy Id is not found"));
		
		PolicyHolder policyHol=policyHolderRepo.findById(PolicyHolderId)
				.orElseThrow(()->new NotFoundException("policyHolder Id is not Found"));
		Admin admin=adminrepo.findById(adminId).orElseThrow(()->new NotFoundException("Admin id not found"));
		
		if(claimrepo.existsByClaimNumber(clmDto.getClaimNumber()))
		{
			throw new NotFoundException("claim number already existed");
		}
		
		Claim cl= new Claim();
		cl.setAmount(clmDto.getAmount());
		cl.setClaimNumber(clmDto.getClaimNumber());
		cl.setFillingDate(LocalDate.now());
		cl.setStatus(clmDto.getStatus());
		cl.setAdmin(admin);
		cl.setPolicy(policy);
		cl.setPolicyHolder(policyHol);
		return claimrepo.save(cl);
	}
	
	/***************************************************************************************
	 * Updates an existing claim.
	 *
	 * @param id The ID of the claim to update
	 * @param status The new status for the claim
	 * @param amount The new amount for the claim
	 * @return A success message if the claim is updated successfully
	 * @throws NotFoundException If the claim ID is not found
	 ***********************************************************************************************/
	public String updteClaim(Long id,String status,double amount) throws NotFoundException
	{
		Claim cl=claimrepo.findById(id).orElse(null);
		if(cl!=null)
		{
			cl.setAmount(amount);
			cl.setStatus(status);
			claimrepo.save(cl);
			return "update successfully";
		}
		else
		{
			throw new NotFoundException("claim id not found");
		}	}
	
	
	/***********************************************************************************
	 * Deletes a claim by its ID.
	 *
	 * @param id The ID of the claim to delete
	 * @return A message confirming deletion
	 * @throws NotFoundException If the claim ID is not found
	 ***********************************************************************************/
	public String  deletebyId(Long id) throws NotFoundException
	{
		if(claimrepo.existsById(id))
		{
			claimrepo.deleteById(id);
			return "deleted by id";
		}
		else
		{
			throw new NotFoundException("claim id not found");
		}
	}
}
