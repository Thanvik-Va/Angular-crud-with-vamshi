package com.incresol.app.service;

import java.util.List;
import java.util.Optional;

import com.incresol.app.pojo.BusinessPojo;

public interface BusinessPlaceService {
	
	public String saveBusinessPlace(BusinessPojo businessPojo);
	public Optional<BusinessPojo> getBusinessPlace(String orgBpId);
	public List<BusinessPojo> getAllBusinessPlaces();
	public String deleteBusinessPlace(String orgBpId);
}
