package com.organization.service;

import java.util.List;
import java.util.Optional;

import com.organization.entity.ResponseHandler;
import com.organization.pojo.OrganizationPojp;

public interface OrganizationService {
	
	public ResponseHandler saveOrganization(OrganizationPojp organizationPojo);
	
	public ResponseHandler getOrganization(String orgId);
	
	public ResponseHandler getAllOrganizations();
	
	public void deleteOrganization(String orgId);

}
