package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Long>
{
	 /**
     * Checks if a Policy entity exists with the given policyNumber.
     *
     * @param policyNumber The policy number associated with the Policy.
     * @return True if a Policy entity with the given policyNumber exists, otherwise false.
     */
	boolean existsByPolicyNumber(Long polociNumber);
}
