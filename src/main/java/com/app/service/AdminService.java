package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Admin;
import com.app.globalexception.NotFoundException;
import com.app.repository.AdminRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo adminrepo;
	
	/************************************************************************************
	 * Registers a new admin after verifying that the admin name doesn't already exist.
	 * Throws NotFoundException if the admin is already present.
	 *
	 * @param admin The admin object to be registered
	 * @throws NotFoundException If admin with the same name already exists
	 **************************************************************************************/
	public void registerAdmin(Admin admin) throws NotFoundException 
	{
		if(adminrepo.existsByAdminname(admin.getAdminname()))
		{
			throw new NotFoundException("Admin already present");
		}
		adminrepo.save(admin);
	}

	/**********************************************************************************************
	 * Validates admin login by checking credentials.
	 * Throws NotFoundException if the admin doesn't exist or if the password is incorrect.
	 *
	 * @param adminname The admin's username
	 * @param password The admin's password
	 * @throws NotFoundException If admin doesn't exist or if the password is incorrect
	 *****************************************************************************************/
	public void login(String adminname, String password) throws NotFoundException
	{
		if (!adminrepo.existsByAdminname(adminname)) 
		{
		    throw new IllegalArgumentException("Admin does not exist");
		}
		Admin existingAdmin =  adminrepo.findByAdminname(adminname);
		if(!existingAdmin.getPassword().equals(password))
		{
			throw new NotFoundException("Incorrect Password");
		}
	}
	
	/********************************************************************************
	 * Deletes an admin by ID if it exists, else throws NotFoundException.
	 *
	 * @param adminId The ID of the admin to be deleted
	 * @throws NotFoundException If admin with the given ID does not exist
	 ***********************************************************************************/
	public void deleteAdmin(int adminId) throws NotFoundException {
		Optional<Admin> admin =adminrepo.findById(adminId);
		if (admin.isPresent())
		{
			adminrepo.deleteById(adminId);
		}
		else
		{
			throw new NotFoundException("Admin does not exist");
		}
		
	}
}
