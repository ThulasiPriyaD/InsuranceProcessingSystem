package com.sprint;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.controller.PolicyController;
import com.app.entity.Policy;
import com.app.service.PolicyService;

@ExtendWith(MockitoExtension.class)
public class PolicyTests 
{
	@Mock
	private PolicyService policyService;
	
	@InjectMocks
	private PolicyController policyController;

	@Test
	public void testGetAllPolicy()
	{
		equals(policyController.allpolicies());
	}
	
	@Test
	public void testGetById()
	{
		long policyId=1L;
		Optional<Policy> policy=policyController.getbypolicyId(policyId);
		equals(policy);
	}
}
