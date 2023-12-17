package com.sprint;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.controller.ClaimController;
import com.app.entity.Claim;
import com.app.service.ClaimService;

@ExtendWith(MockitoExtension.class)
public class ClaimTests 
{

	@Mock
	private ClaimService claimsevice;
	
	@InjectMocks
	private ClaimController claimController;
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testGetAllClaims()
	{
		// Mocking the service response
       equals(claimController.getAllClaim()); 	
	}
	@Test
	public void testGetByClaimId()
	{
		long claimId=1L;
		Optional<Claim> opt=claimController.getById(claimId);
		equals(opt);
	}
}
