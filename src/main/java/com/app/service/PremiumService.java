package com.app.service;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PremiumDto;
import com.app.entity.Policy;
import com.app.entity.Premium;
import com.app.globalexception.NotFoundException;
import com.app.repository.*;


import jakarta.validation.Valid;

@Service
public class PremiumService {

	@Autowired
	private PremiumRepo repo;

	@Autowired
	private PolicyRepo policyrepo;

	/******************************************************************************************
	 * Retrieve all premiums from the repository.
	 **********************************************************************************************/
	public List<Premium> getAll(){
		return repo.findAll();

	}

	/*********************************************************************************************
	 * Retrieve a premium by its ID.
	 * @throws NotFoundException if the premium ID doesn't exist.
	 **************************************************************************************************/
	public Optional<Premium> getPremiumById(Long premiumId) throws NotFoundException{

		if(repo.existsById(premiumId))
		{
			return repo.findById(premiumId);
		}
		else
		{
			throw new NotFoundException("premium id is not found");
		}
	}

	/*************************************************************************************************
	 * Create a new premium for a given policy ID and PremiumDto.
	 * @throws NotFoundException if the policy ID or policy number already exists.
	 ****************************************************************************************************/
	public Premium createPremium(Long policyId, @Valid PremiumDto premiumdto) throws NotFoundException {



		if(repo.existsByPolicyNumber(premiumdto.getPolicyNumber())) {
			throw new NotFoundException("Policy Number already exists");
		}

		Policy policy=policyrepo.findById(policyId).orElseThrow(()-> new NotFoundException("policy Id is not found"));

		Premium p = new Premium();
		p.setAmount(premiumdto.getAmount());
		p.setPolicyNumber(premiumdto.getPolicyNumber());										
		p.setStatus(premiumdto.getStatus());
		p.setDueDate(LocalDate.now());
		p.setPolicy(policy);
		return repo.save(p);
	}

	/********************************************************************************************
	 * Update an existing premium by its ID and new PremiumDto information.
	 * @throws NotFoundException if the premium ID doesn't exist.
	 ***********************************************************************************************/
	public Premium updatePremium(Long premiumId, @Valid PremiumDto premiumdto) throws NotFoundException {

		Premium p = repo.findById(premiumId).orElse(null);
		if (repo.existsById(premiumId)) {

			p.setStatus(premiumdto.getStatus());
			return repo.save(p);

		} else {
			throw new NotFoundException("Premium not found with id: " + premiumId);
		}
	}


	/*********************************************************************************************
	 * Delete a premium by its ID.
	 * @throws NotFoundException if the premium ID doesn't exist.
	 ********************************************************************************************/
	public String deletePremium(Long premiumId) throws NotFoundException{

		if(repo.existsById(premiumId)) {

			repo.deleteById(premiumId);
			return "Deleted by ID";
		}else {
			throw new NotFoundException("Claim ID not found");
		}

	}

}

