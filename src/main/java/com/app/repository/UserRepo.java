package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

	/**
     * Checks if a User entity exists with the given userName.
     *
     * @param userName The user name associated with the User.
     * @return True if a User entity with the given userName exists, otherwise false.
     */
	boolean existsByUserName(String userName);
	
	/**
     * Checks if a User entity exists with the given emailId.
     *
     * @param emailId The email address associated with the User.
     * @return True if a User entity with the given emailId exists, otherwise false.
     */
	boolean existsByEmailId(String emailId);
	
}
