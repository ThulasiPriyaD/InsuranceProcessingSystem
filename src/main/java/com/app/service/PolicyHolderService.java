package com.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dto.PolicyHolderDto;
import com.app.entity.PolicyHolder;
import com.app.globalexception.NotFoundException;
import com.app.repository.PolicyHolderRepo;
import jakarta.validation.Valid;

@Service
public class PolicyHolderService
{

	@Autowired
	PolicyHolderRepo policyholdrepo;
	
	/***************************************************************************************
	 * Retrieves all PolicyHolders from the repository.
	 * 
	 * @return List of PolicyHolders
	 ***************************************************************************************/

	  public List<PolicyHolder> getAllPolicyHolders() {
	        return  policyholdrepo.findAll();
	    }
	  
	  /***************************************************************************************
		 * Retrieves a specific PolicyHolder by its ID from the repository.
		 * 
		 * @param policyHolderId The ID of the PolicyHolder to retrieve
		 * @return Optional containing the PolicyHolder, or an empty Optional if not found
		 ***************************************************************************************/
	  
	  public Optional<PolicyHolder> getPolicyHolderById(Long policyHolderId) {
	        return policyholdrepo.findById(policyHolderId);
	    }
	  
	  /***************************************************************************************
		 * Creates a new PolicyHolder based on the provided PolicyHolderDto.
		 * 
		 * @param dto The PolicyHolderDto containing information for the new PolicyHolder
		 * @return The created PolicyHolder
		 * @throws NotFoundException if the email or phone number already exists
		 ***************************************************************************************/
	  
	  public PolicyHolder createPolicyHolder(@Valid PolicyHolderDto dto) throws NotFoundException
	    {
	    	if(policyholdrepo.existsByEmail(dto.getEmail()) && policyholdrepo.existsByPhoneNumber(dto.getPhoneNumber()))
	    	{
	    		throw new NotFoundException("email and phone number already existed");
	    		
	    	}
	    	
	    	PolicyHolder pl=new PolicyHolder();
	    	pl.setAddress(dto.getAddress());
	    	pl.setFirstName(dto.getFirstName());
	    	pl.setLastName(dto.getLastName());
	    	pl.setPhoneNumber(dto.getPhoneNumber());
	    	pl.setEmail(dto.getEmail());
	    	
	    	return policyholdrepo.save(pl);
	    }
	  
	  /***************************************************************************************
		 * Updates an existing PolicyHolder with the provided information.
		 * 
		 * @param id The ID of the PolicyHolder to update
		 * @param dto The PolicyHolderDto containing updated information
		 * @return A message indicating the success of the update
		 * @throws NotFoundException if the PolicyHolder ID is not found or if the new phone number already exists
		 ***************************************************************************************/
	  public String updatePolicyHol(Long id,@Valid PolicyHolderDto dto) throws NotFoundException
	  {
		  PolicyHolder po=policyholdrepo.findById(id).orElse(null);
		  if(po!=null)
		  {
			  po.setFirstName(dto.getFirstName());
			  po.setLastName(dto.getLastName());
			  po.setAddress(dto.getAddress());
			  if(policyholdrepo.existsByPhoneNumber(dto.getPhoneNumber()))
			  {
				  throw new NotFoundException("phone number already existed");
			  }
			  else
			  {
				  po.setPhoneNumber(dto.getPhoneNumber());
			  }
			  policyholdrepo.save(po);
			  
			  return "updated success fully";
		  }
		  return "PolicyHolderId not found";
	  }
	  
	  /***************************************************************************************
		 * Deletes a PolicyHolder with the specified ID.
		 * 
		 * @param id The ID of the PolicyHolder to delete
		 * @return A message indicating the success of the deletion
		 * @throws NotFoundException if the PolicyHolder ID is not found
		 ***************************************************************************************/
	  public String deletePolicyHolder(Long id) throws NotFoundException
	  {
		  if(policyholdrepo.existsById(id))
		  {
			  policyholdrepo.deleteById(id);
			  return "deleted successfully";
		  }
		  else
		  {
			  throw new NotFoundException("delete id not found");
		  }
	  }
}
