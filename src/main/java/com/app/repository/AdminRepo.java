package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Admin;

/**
 * Repository interface for managing CRUD operations on the Admin entity.
 * Extends JpaRepository to provide basic functionality for working with the Admin entity.
 */
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>
{

	 /**
     * Checks if an Admin entity exists with the given adminname.
     *
     * @param adminname The username of the admin.
     * @return True if an Admin entity with the given adminname exists, otherwise false.
     */
	boolean existsByAdminname(String adminname);
	
	/**
     * Retrieves an Admin entity by its adminname.
     *
     * @param adminname The username of the admin.
     * @return The Admin entity with the specified adminname.
     */
	Admin findByAdminname(String adminname);
}
