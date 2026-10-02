package org.rodion.solution.service;

import java.util.List;

import org.rodion.solution.entity.Facility;

public interface FacilityService {
	
	public Facility addFacility(Facility facility);

	public Facility updateFacility(Facility facility);

	public Facility getFacilityById(Integer facilityId);

	public List<Facility> findAllFacility();

	public Boolean deleteFacilityByid(Integer facilityId);
}
