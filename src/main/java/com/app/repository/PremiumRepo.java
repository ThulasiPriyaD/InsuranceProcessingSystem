package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Premium;

@Repository
public interface PremiumRepo extends JpaRepository<Premium,Long>{

	   /**
     * Checks if a Premium entity exists with the given policyNumber.
     *
     * @param policyNumber The policy number associated with the Premium.
     * @return True if a Premium entity with the given policyNumber exists, otherwise false.
     */
	boolean existsByPolicyNumber(String PolicyNumber);
}
