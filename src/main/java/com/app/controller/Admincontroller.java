package com.app.controller;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.service.*;
import com.app.entity.*;
import com.app.globalexception.NotFoundException;



import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class Admincontroller {

	/*
	 * { Admin Register
  "adminId": 0,
  "adminname": "AdminrCKveIQGt8BpaeDb7oOkLEFKX0nMa7OQ9pDPFX1od0GXZUvdpNJtzwbV7tHcRUOSCgtsuQvMHYE8e1t",
  "password": "aad@G&n3B~]MKr|MrDv$6f30}q-_%dq"
   }
	 */

	/*


	 * {  Admin Login
  "adminId": 0,
  "adminname": "Adminrc1OisHmAQdvxsE11ZnHb9RuiqgrzbvRxJoSjdyjzs38WOHSIGe5RCj6jUBAnlWrg13V4OOcP",
  "password": "=QH|ek@J}/'\"Bz%Q?&u7_t$6vrq[2#w.DZQ!&>"
   }
	 */

	// Logger for logging controller actions
	private static final Logger logger = LoggerFactory.getLogger(Admincontroller.class);

	// Autowired service for handling admin operations
	@Autowired
	private  AdminService adminservice;

	public AdminService getAdminservice() {
		return adminservice;
	}

	public void setAdminservice(AdminService adminservice) {
		this.adminservice = adminservice;
	}

	/***************************************************************************************
	 * Endpoint for registering a new admin.
	 * 
	 * @param admin The Admin object to register
	 * @return ResponseEntity indicating the success of the registration and HTTP status code
	 * @throws NotFoundException if an issue occurs during registration
	 ***************************************************************************************/
	@PostMapping("/registerAdmin")
	public ResponseEntity<String> addAdmin(@Valid @RequestBody Admin admin) throws NotFoundException
	{
		Admin a1 = new Admin(admin.getAdminId(),admin.getAdminname(),admin.getPassword());
		logger.info("Fetching all policy holders");
		adminservice.registerAdmin(a1);

		return new ResponseEntity<>("Admin register Sucessfully",HttpStatus.CREATED);
	}

	/***************************************************************************************
	 * Endpoint for admin login.
	 * 
	 * @param admin The Admin object containing login credentials
	 * @return ResponseEntity indicating the success of the login and HTTP status code
	 * @throws NotFoundException if the login fails
	 ***************************************************************************************/
	@PostMapping("/loginAdmin")
	public ResponseEntity<String> loginAdmin(@RequestBody Admin admin) throws NotFoundException
	{
		logger.info("Logging in admin");
		adminservice.login(admin.getAdminname(), admin.getPassword());
		return new ResponseEntity<>("Admin LogIn Sucessfully",HttpStatus.OK);

	}

	/***************************************************************************************
	 * Endpoint for deleting an admin by ID.
	 * 
	 * @param adminId The ID of the admin to delete
	 * @return ResponseEntity indicating the success of the deletion and HTTP status code
	 * @throws NotFoundException if the admin ID is not found
	 ***************************************************************************************/
	@DeleteMapping("/deleteAdmin/{adminId}")
	public ResponseEntity<String> deleteAdminById(@PathVariable Integer adminId ) throws NotFoundException
	{
		logger.info("Deleting admin with ID");
		adminservice.deleteAdmin(adminId);
		return new ResponseEntity<>("Admin Profile Deleted successfully", HttpStatus.ACCEPTED);
	}

	//Autowired services for handling various operations
	@Autowired
	private ClaimService claimService;

	@Autowired
	private UserService uservice;

	@Autowired
	private PolicyService policyservice;

	@Autowired
	private PremiumService service;

	@Autowired
	private PolicyHolderService policyholderservice;
	
	
	/***************************************************************************************
	 * Endpoints for managing claims, users, policies, premiums, and policy holders.
	 * 
	 * The methods include fetching all, fetching by ID, and deleting by ID for each entity.
	 * The logger is used to log the actions performed.
	 ***************************************************************************************/

	@GetMapping("/getAllClaim")
	public List<Claim> getAllClaim()
	{
		logger.info("Fetching all claims");
		return claimService.getAllClaims();
	}

	@GetMapping("/getByClaimId/{claimId}")
	public Optional<Claim> getById(@PathVariable Long claimId)
	{
		logger.info("Fetching claim by ID");
		return claimService.getClaimById(claimId);
	}

	@DeleteMapping("/deleteClaim/{claimId}")
	public ResponseEntity<String> deleteByClaim(@PathVariable Long claimId) throws NotFoundException
	{
		logger.info("Deleting claim with ID");
		String deleteClaim=claimService.deletebyId(claimId);
		return ResponseEntity.status(HttpStatus.CREATED).body(deleteClaim);
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllusers()
	{
		logger.info("Fetching all users");
		return uservice.getAll();
	}

	@GetMapping("/getUsersById/{userId}")
	public Optional<User> getUserById(@PathVariable Long userId)
	{
		logger.info("Fetching user by ID");
		return uservice.getByid(userId);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) throws NotFoundException
	{
		logger.info("Deleting user with ID");
		String delete=uservice.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(delete);
	}

	@GetMapping("/getAllPolicies")
	public List<Policy> allpolicies()
	{
		logger.info("Fetching all policies");
		return policyservice.getAllPolicys();
	}

	@GetMapping("getByPolicyId/{policyId}")
	public Optional<Policy> getbypolicyId(@PathVariable Long policyId)
	{
		logger.info("Fetching policy by ID");
		return policyservice.getpolicy(policyId);
	}

	@DeleteMapping("/deletePolicy/{policyId}")
	public ResponseEntity<String> deletePolicy(@PathVariable Long policyId) throws NotFoundException
	{
		logger.info("Deleting policy with ID");
		String deleted=policyservice.deletePolId(policyId);
		return ResponseEntity.status(HttpStatus.CREATED).body(deleted);
	}

	@GetMapping("/getallPremiums")
	public List<Premium> getallpremiums()
	{
		logger.info("Fetching all premiums");
		return service.getAll();
	}

	@GetMapping("/getByPremiumId/{premiumId}")
	public Optional<Premium> getbyPremiumId(@PathVariable Long premiumId) throws NotFoundException
	{
		logger.info("Fetching premium by ID");
		return service.getPremiumById(premiumId);
	}

	@DeleteMapping("/deletePremiums/{premiumId}")
	public ResponseEntity<String> deletingId(@PathVariable Long premiumId) throws NotFoundException
	{
		logger.info("Deleting premium with ID");
		String delete=service.deletePremium(premiumId);
		return ResponseEntity.status(HttpStatus.CREATED).body(delete);
	}


	@GetMapping("/getAllPolicyHolder")
	public List<PolicyHolder> getAllPolicyHolder(){

		logger.info("Fetching all policy holders");
		return policyholderservice.getAllPolicyHolders();

	}

	@GetMapping("/getByIdPolicyHolderId/{policyHolderId}")
	public Optional<PolicyHolder> getPolicyHolderById(@PathVariable Long policyHolderId){
		logger.info("Fetching policy holder by ID:");
		return policyholderservice.getPolicyHolderById(policyHolderId);
	}

	@DeleteMapping("/deletePolicyHolder/{PolicyHolderId}")
	public ResponseEntity<String> deletedPolicyHolder(@PathVariable Long PolicyHolderId) throws NotFoundException
	{
		logger.info("Deleting user with ID");
		String delete=policyholderservice.deletePolicyHolder(PolicyHolderId);
		logger.warn("Invalid user data received");
		return ResponseEntity.status(HttpStatus.CREATED).body(delete);
	}
}

