package com.organization.controller;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.entity.Organization;
import com.organization.entity.ResponseHandler;
import com.organization.pojo.OrganizationPojp;

import com.organization.service.OrganizationServiceImp;

@RestController
@RequestMapping(value="/org")
@CrossOrigin("http://localhost:4200")
public class OrganizationController {

	@Autowired
	private OrganizationServiceImp organizationService;

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();

	@PostMapping(value="/createOrganization")
	public ResponseEntity<Object> createOrganization(@RequestBody OrganizationPojp organization) {
		logger.info("Entered into create-organize-section");
		ResponseHandler handler = organizationService.saveOrganization(organization);
		return new ResponseEntity<>(handler,HttpStatus.OK);
	}
	   

	@GetMapping("/getBy/{orgId}")
	public ResponseEntity<Object> getOrganization(@PathVariable String orgId) {
		logger.info("Entered into get-organization-section"+orgId);
		ResponseHandler handler = organizationService.getOrganization(orgId);
		return new ResponseEntity<>(handler,HttpStatus.OK);
		
	}

	@GetMapping("/getAllOrganizations")
	public ResponseEntity<Object> getAllOrganizations() {
		logger.info("Entered into get-AllOrganization-section");
		ResponseHandler handler = organizationService.getAllOrganizations();
		return new ResponseEntity<>(handler,HttpStatus.OK);
		
	}

//	@DeleteMapping("/delete/{orgId}")
//	public void deleteOrganization(@PathVariable String orgId) {
//		logger.info("Entered into delete-organization-section");
//		organizationService.deleteOrganization(orgId);
//	}

}
