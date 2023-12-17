package com.sprint;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.controller.PremiumController;
import com.app.entity.Premium;
import com.app.globalexception.NotFoundException;
import com.app.service.PremiumService;

@ExtendWith(MockitoExtension.class)
public class PremiumTest
{

	@Mock
	private PremiumService premiumService;
	
	@InjectMocks
	private PremiumController premiumController;
	
	@Test
	public void testGetAll()
	{
		// Mocking the service response
	       equals(premiumController.getallpremiums());
	}
	
	@Test
	public void testGetPremiumId() throws NotFoundException
	{
		long premiumId=1L;
		Optional<Premium> opt=premiumController.getbyPremiumId(premiumId);
		equals(opt);
	}
}
