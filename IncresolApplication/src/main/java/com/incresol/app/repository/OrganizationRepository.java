package com.incresol.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incresol.app.entity.Organization;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String> {
	
}
