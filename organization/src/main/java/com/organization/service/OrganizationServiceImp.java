package com.organization.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.entity.BusinessPlace;
import com.organization.entity.Organization;
import com.organization.entity.ResponseHandler;
import com.organization.pojo.BusinessPojo;
import com.organization.pojo.OrganizationPojp;
import com.organization.repository.OrganizationRepository;

@Service
public class OrganizationServiceImp implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();

	public ResponseHandler getResponse(String message, int status, int errorCode, Object o) {
		ResponseHandler handler = new ResponseHandler();
		Map<String, Object> response = handler.getResponse();
		response.put("data", o);
		handler.setErrorCode(errorCode);
		handler.setMessage(message);
		handler.setStatusCode(status);

		return handler;
	}

	// save or create organization
	public ResponseHandler saveOrganization(OrganizationPojp organizationPojo) {

		logger.info("Entered into save-organize-section");

		Organization organization = new Organization();
		String message = "";
		ResponseHandler response = null;
		try {
			organizationPojo.setOrgId(UUID.randomUUID().toString());
			BeanUtils.copyProperties(organizationPojo, organization);
			if (organizationPojo.getBusinessPlaces() != null) {
				List<BusinessPojo> businessPlacesPojo = organizationPojo.getBusinessPlaces();

				List<BusinessPlace> bpPlace = new ArrayList<>();
				businessPlacesPojo.stream().forEach(bpPojo -> {
					bpPojo.setBusinessPlaceId(UUID.randomUUID().toString());
					BusinessPlace businessPlace = new BusinessPlace();
					BeanUtils.copyProperties(bpPojo, businessPlace);
				});
				organization.setBusinessPlaces(bpPlace);

			}

			message = "Organization created successfully";
			response = getResponse(message, 0, 0, organizationRepository.save(organization));
			logger.info("Organization saved successfully..!!");

		} catch (Exception e) {

			e.printStackTrace();
			message = "Something went wrong";
			response = getResponse(message, 1, 1, "Organization is not saved..!!");
			logger.error("Organization is not saved..!!");

		}
		logger.info("Exited from save-organization-section");
		// BeanUtils.copyProperties(organization, organizationPojo);
		return response;

	}

	// fetch organization
	public ResponseHandler getOrganization(String orgId) {

		ResponseHandler handler=null;
		try {
			Optional<Organization> optionalOrganization = organizationRepository.findById(orgId);

			if (optionalOrganization.isPresent()) {
				Organization organization = optionalOrganization.get();

				// Check if deleteStatus is 0

				OrganizationPojp organizationPojp = new OrganizationPojp();
				List<BusinessPlace> businessPlaces = organization.getBusinessPlaces();

				// Filter business places with deleteStatus as 0
				List<BusinessPojo> businessPojos = businessPlaces.stream().filter(bp -> bp.getDeleteStatus() == 0)
						.map(bp -> 
						{
							BusinessPojo pojo = new BusinessPojo();
							BeanUtils.copyProperties(bp, pojo);
							return pojo;
						})
						.collect(Collectors.toList());

				BeanUtils.copyProperties(organization, organizationPojp);
				organizationPojp.setBusinessPlaces(businessPojos);
				handler=getResponse("Organization fetched successfully", 0, 0, organizationPojp);
				return handler;

			} else {
				handler= getResponse("Organization not found", 1, 1, "Organization details not fetched successfully");
				return handler;
			}
		} catch (Exception e) {
			logger.error("Exception occurred while fetching organization details", e);
			handler=getResponse("Something went wrong", 1, 1, "Organization details not fetched successfully");
			return handler;
		}
	}

	// fetch all organization details

	public ResponseHandler getAllOrganizations() {

		logger.info("Entered into get-all-organization-section");
		String message = "";
		ResponseHandler response = null;
		List<OrganizationPojp> orgPojo = new ArrayList<>();

		try {

			List<Organization> findAll = organizationRepository.findAll();

			findAll.stream().forEach(organization -> {
				OrganizationPojp organizationPojp = new OrganizationPojp();
				BeanUtils.copyProperties(organization, organizationPojp);
				List<BusinessPlace> businessPlaces = organization.getBusinessPlaces();
				List<BusinessPojo> businessPojos = new ArrayList<>();
				businessPlaces.stream().forEach(businessPlace -> {
					BusinessPojo businessPojo = new BusinessPojo();
					BeanUtils.copyProperties(businessPlace, businessPojo);
					businessPojos.add(businessPojo);
				});
				organizationPojp.setBusinessPlaces(businessPojos);
				orgPojo.add(organizationPojp);

			});

			message = "Organization fecthed successfully";
			response = getResponse(message, 0, 0, orgPojo);

			logger.info("All organizations are fetched successufully");
		} catch (Exception e) {
			// TODO: handle exception
			message = "Something went wrong..!!";
			response = getResponse(message, 1, 1, "Organization details not fetched successfully");
			logger.error("Something went wrong");

		}
		logger.info("Exited from get-all-organization-section");
		return response;
	}

	// delete organization

	public void deleteOrganization(String orgId) {

		logger.info("Entered into delete-organization-section");
		try {
			organizationRepository.deleteById(orgId);
			logger.info(orgId + " is deleted successfully");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(orgId + " is Invalid");
		}
		logger.info("Exited from delete-organization-section");

	}

}
