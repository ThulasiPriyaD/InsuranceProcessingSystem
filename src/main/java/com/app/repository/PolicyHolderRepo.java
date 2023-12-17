package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.PolicyHolder;

@Repository
public interface PolicyHolderRepo extends JpaRepository<PolicyHolder, Long>
{
	/**
     * Checks if a PolicyHolder entity exists with the given email.
     *
     * @param email The email address associated with the PolicyHolder.
     * @return True if a PolicyHolder entity with the given email exists, otherwise false.
     */
	boolean existsByEmail(String email);
	
	/**
     * Checks if a PolicyHolder entity exists with the given phoneNumber.
     *
     * @param phoneNumber The phone number associated with the PolicyHolder.
     * @return True if a PolicyHolder entity with the given phoneNumber exists, otherwise false.
     */
	boolean existsByPhoneNumber(String phoneNumber);
}
