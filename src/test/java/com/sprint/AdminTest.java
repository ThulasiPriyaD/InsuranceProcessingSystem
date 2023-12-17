package com.sprint;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.controller.*;
import com.app.entity.*;
import com.app.globalexception.NotFoundException;
import com.app.service.*;



@ExtendWith(MockitoExtension.class)
public class AdminTest {

	@Mock
	private PolicyService policyService;
	
	@Mock
	private PremiumService premiumService;
	
	@InjectMocks
	private Admincontroller adminController;

	@Test
	public void testGetAllPolicy()
	{
		equals(adminController.allpolicies());
	}
	
	@Test
	public void testGetById()
	{
		long policyId=1L;
		Optional<Policy> policy=adminController.getbypolicyId(policyId);
		equals(policy);
	}
	
	@Test
	public void testGetAll()
	{
		// Mocking the service response
	       equals(adminController.getallpremiums());
	}
	
	@Test
	public void testGetPremiumId() throws NotFoundException
	{
		long premiumId=1L;
		Optional<Premium> opt=adminController.getbyPremiumId(premiumId);
		equals(opt);
	}
}
