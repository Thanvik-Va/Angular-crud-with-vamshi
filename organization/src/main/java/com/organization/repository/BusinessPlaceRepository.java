package com.organization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.entity.BusinessPlace;

@Repository
public interface BusinessPlaceRepository extends JpaRepository<BusinessPlace, String>{

	// find bp by using orgId
	 List<BusinessPlace> findByOrganizationOrgId(String orgId);
}
