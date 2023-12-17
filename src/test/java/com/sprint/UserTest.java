package com.sprint;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.controller.UserController;
import com.app.entity.User;
import com.app.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserTest 
{
	
	@Mock
	private UserService userService;
	@InjectMocks
	private UserController userController;
	
	@Test
	public void testGetAllUsers()
	{
		equals(userController.getAllusers());
	}
	
	@Test
	public void testGetById()
	{
		long userId=1L;
		Optional<User> user=userController.getUserById(userId);
		equals(user);
	}
}
