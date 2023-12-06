package com.incresol.app.service;

import java.util.List;
import java.util.Optional;

import com.incresol.app.entity.ResponseHandler;
import com.incresol.app.pojo.OrganizationPojp;

public interface OrganizationService {
	
	public ResponseHandler saveOrganization(OrganizationPojp organizationPojo);
	
	public ResponseHandler getOrganization(String orgId);
	
	public ResponseHandler getAllOrganizations();
	
	public void deleteOrganization(String orgId);

}
