package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entity.User;
import com.app.globalexception.NotFoundException;
import com.app.repository.UserRepo;

import jakarta.validation.Valid;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	/***************************************************************************************
	* Retrieve all users from the repository.
	*********************************************************************************************/
	public List<User> getAll()
	{
		return repo.findAll();
	}
	
	/***************************************************************************************
	* Retrieve a user by its Id.
	*********************************************************************************************/
	public Optional<User> getByid(Long id)
	{
		return repo.findById(id);
	}
	
	
	/*******************************************************************************************
	* Create a new user based on the provided UserDto.
	* @throws NotFoundException if username or email already exists.
	********************************************************************************************/
	public User creatingUser(@Valid UserDto dto) throws NotFoundException
	{
		if(repo.existsByUserName(dto.getUserName())&& repo.existsByEmailId(dto.getEmailId()))
		{
			throw new NotFoundException("username and email already existed");
		}
		else
		{
			User us =new User();
			us.setEmailId(dto.getEmailId());
			us.setMobNo(dto.getMobNo());
			us.setPassword(dto.getPassword());
			us.setUserName(dto.getUserName());
			return repo.save(us);
		}
	}
	
	/**************************************************************************************************
	* Update user's mobile number by user ID.
	* @throws NotFoundException if the user ID doesn't exist.
	***************************************************************************************************/
	public User UpdateUser(Long id, String mobNo ) throws NotFoundException {
		
		User us=repo.findById(id).orElse(null);
		if(us!=null)
		{
			us.setMobNo(mobNo);
			return repo.save(us);
		}
		else
		{
			throw new NotFoundException("userId not found");
		}
	}
	
	/***************************************************************************************
	* Delete a user by user ID.
	* @throws NotFoundException if the user ID doesn't exist.
	********************************************************************************************/
	public String deleteUser(Long id) throws NotFoundException
	{
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return "user deleted successfully";
		}
		else
		{
			throw new NotFoundException("userid not found");
		}
	}

}
