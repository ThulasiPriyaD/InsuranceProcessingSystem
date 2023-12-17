package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.app.dto.UserDto;
import com.app.entity.User;
import com.app.globalexception.NotFoundException;
import com.app.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aps/user")
public class UserController 
{
	/*
	Password should contains at least 8 characters and at most 20 characters.
	It should contains at least one digit.
	It should contains at least one upper case alphabet.
	It should contains at least one lower case alphabet.
	It should contains at least one special character which includes !@#$%&*()-+=^.
	It should doesn’t contain any white space.
	where:
	^ represents starting character of the string.
	(?=.*[0-9]) represents a digit must occur at least once.
	(?=.*[a-z]) represents a lower case alphabet must occur at least once.
	(?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
	(?=.*[@#$%^&-+=()] represents a special character that must occur at least once.
	(?=\\S+$) white spaces don’t allowed in the entire string.
	.{8, 20} represents at least 8 characters and at most 20 characters.
	$ represents the end of the string.
*/
	/*
	 * {
  		"userName": "19crJlN5MOPCYHQVnqU8KizSOv4V0cL3pAfQ9l4v0lsj5B",
		"password": "5w3c3hlN/`cV4Ka+1^m>",
  		"mobNo": "7965037965",
		"emailId": "string"
		}
	 */
	
	// Logger for logging controller actions
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// Autowired service for handling user operations
	@Autowired
	UserService uservice;
	
	/***************************************************************************************
	 * Endpoint for fetching all users.
	 * 
	 * @return List of all users
	 ***************************************************************************************/
	@GetMapping("/getAll")
	public List<User> getAllusers()
	{
		logger.info("Fetching all users");
		return uservice.getAll();
	}
	
	/***************************************************************************************
	 * Endpoint for fetching a user by ID.
	 * 
	 * @param userId The ID of the user to fetch
	 * @return Optional containing the user with the specified ID
	 ***************************************************************************************/
	@GetMapping("/get/{userId}")
	public Optional<User> getUserById(@PathVariable Long userId)
	{
		logger.info("Fetching user by ID");
		return uservice.getByid(userId);
	}
	
	/***************************************************************************************
	 * Endpoint for creating a new user.
	 * 
	 * @param dto The UserDto object containing user details
	 * @return ResponseEntity indicating the success of the creation and HTTP status code
	 * @throws NotFoundException if an issue occurs during user creation
	 ***************************************************************************************/
	@PostMapping("/create")
	public ResponseEntity<User> create(@Valid @RequestBody UserDto dto) throws NotFoundException
	{
	    logger.info("Creating user");
		User us=uservice.creatingUser(dto);
		logger.warn("Invalid user data received");
		return ResponseEntity.status(HttpStatus.CREATED).body(us);
	}
	
	/***************************************************************************************
	 * Endpoint for updating a user's mobile number.
	 * 
	 * @param userId The ID of the user to update
	 * @param mobile The new mobile number to set
	 * @return ResponseEntity indicating the success of the update and HTTP status code
	 * @throws NotFoundException if the user ID is not found
	 ***************************************************************************************/
	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updated(@PathVariable Long userId,@RequestParam String mobile) throws NotFoundException
	{
		logger.info("Updating user with ID");
		User us=uservice.UpdateUser(userId, mobile);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(us);
	}
	
	/***************************************************************************************
	 * Endpoint for deleting a user by ID.
	 * 
	 * @param userId The ID of the user to delete
	 * @return ResponseEntity indicating the success of the deletion and HTTP status code
	 * @throws NotFoundException if the user ID is not found
	 ***************************************************************************************/
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) throws NotFoundException
	{
		logger.info("Deleting user with ID");
		String delete=uservice.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(delete);
	}
	
}
