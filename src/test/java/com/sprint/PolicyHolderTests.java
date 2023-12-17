package com.sprint;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.controller.PolicyHolderController;
import com.app.entity.PolicyHolder;
import com.app.service.PolicyHolderService;

@ExtendWith(MockitoExtension.class)
public class PolicyHolderTests 
{
	@Mock
	private PolicyHolderService policyHolderService;
	@InjectMocks
	private PolicyHolderController policyHolderController;
	
	
	@Test
	public void testGetAllPolicyHolder()
	{
		equals(policyHolderController.getAllPolicyHolder());
	}
	
	@Test
	public void testGetById()
	{
		long polHolid=1L;
		Optional<PolicyHolder> policyHolder=policyHolderController.getPolicyHolderById(polHolid);
		equals(policyHolder);
	}
}
