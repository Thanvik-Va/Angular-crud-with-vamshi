package com.organization.pojo;

import java.util.List;

import com.organization.entity.BusinessPlace;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationPojp {
	
	
	private String orgId;

	
	private String organizationName;

	
	private String countryName;


	private String stateName;

	
	private String addressLine1;

	
	private String addressLine2;


	private String zipCode;

	
	private String contact;
	
	
	private List<BusinessPojo> businessPlaces;

}
