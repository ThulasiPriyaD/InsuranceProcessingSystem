package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.policyDto;
import com.app.entity.*;
import com.app.globalexception.NotFoundException;
import com.app.repository.*;

import jakarta.validation.Valid;

@Service
public class PolicyService {

	@Autowired
	PolicyRepo policyrepo;
	
	@Autowired
	PolicyHolderRepo policyHolderRepo;
	
	/*****************************************************************************************
	 * Retrieves all existing policies.
	 *
	 * @return List of all policies
	 ****************************************************************************************/
	public List<Policy> getAllPolicys()
	{
		return policyrepo.findAll();
	}
	
	/********************************************************************************
	 * Retrieves a policy by ID.
	 *
	 * @param id The ID of the policy to retrieve
	 * @return Optional containing the policy if found, else empty
	 ****************************************************************************************/
	public Optional<Policy> getpolicy(Long id)
	{
		return policyrepo.findById(id);
	}
	
	/**********************************************************************************************************
	 * Creates a new policy.
	 *
	 * @param policyHolderId The ID of the associated policy holder
	 * @param poldto The policy details
	 * @return The created policy
	 * @throws NotFoundException If the policy holder ID is not found or if the policy number already exists
	 **************************************************************************************************************/
	public Policy createPolicy(Long policyHolderId,@Valid policyDto poldto) throws NotFoundException
	{
		PolicyHolder poli=policyHolderRepo.findById(policyHolderId)
				.orElseThrow(()-> new NotFoundException("PolicyHolderId is not found"));
		
		if(policyrepo.existsByPolicyNumber(poldto.getPolicyNumber()))
		{
			throw new NotFoundException("policy number already existed");
		}
		Policy pl =new Policy();
		pl.setAmount(poldto.getAmount());
		pl.setPolicyName(poldto.getPolicyName());
		pl.setPolicyNumber(poldto.getPolicyNumber());
		pl.setPolicyType(poldto.getPolicyType());
		pl.setStartDate(LocalDate.now());
		pl.setEndDate(LocalDate.now().plusYears(1));
		pl.setPolicyHolder(poli);
		 
		return policyrepo.save(pl);
	}
	
	/*********************************************************************************************
	 * Updates an existing policy by ID.
	 *
	 * @param id The ID of the policy to update
	 * @param name The updated policy name
	 * @param type The updated policy type
	 * @return A message indicating the update status
	 * @throws NotFoundException If the policy ID is not found
	 ***********************************************************************************************/
	public String updateInId(Long id,@Valid String name,String type) throws NotFoundException
	{
		Policy pl=policyrepo.findById(id).orElse(null);
		if(pl!=null)
		{
			pl.setPolicyName(name);
			pl.setPolicyType(type);
			policyrepo.save(pl);
			return "update successfully";
		}
		else
		{
			throw new NotFoundException("policy id not found"+id);
		}
	}
	
	/************************************************************************************************
	 * Deletes a policy by ID.
	 *
	 * @param id The ID of the policy to delete
	 * @return A message confirming deletion
	 * @throws NotFoundException If the policy ID is not found
	 ***********************************************************************************************/
	public String deletePolId(Long id) throws NotFoundException
	{
		if(policyrepo.existsById(id))
		{
			policyrepo.deleteById(id);
			return "deleted successfully";
		}
		else
		{
			throw new NotFoundException("policy id not found"+id);
		}
	}
}
