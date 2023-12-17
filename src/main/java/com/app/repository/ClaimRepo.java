package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Claim;

@Repository
public interface ClaimRepo extends JpaRepository<Claim, Long>
{
	
	/**
     * Checks if a Claim entity exists with the given claimNumber.
     *
     * @param claimNumber The unique identifier for the claim.
     * @return True if a Claim entity with the given claimNumber exists, otherwise false.
     */
	boolean existsByClaimNumber(String claimNumber);
}
