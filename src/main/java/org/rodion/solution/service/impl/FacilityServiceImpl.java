package org.rodion.solution.service.impl;

import java.util.List;

import org.rodion.solution.entity.Facility;
import org.rodion.solution.entity.Room;
import org.rodion.solution.repository.FacilityRepository;
import org.rodion.solution.repository.RoomRepository;
import org.rodion.solution.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityServiceImpl implements FacilityService{

	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public Facility addFacility(Facility facility) {
		List<Integer> roomIdList = facility.getRoomIdList();
		if(roomIdList != null && !roomIdList.isEmpty()) {
			for(Integer roomId : roomIdList) {
				Room room = roomRepository.getRoomById(roomId);
				facility.addRoom(room);
			}
		}else {
			facility.addRoom(roomRepository.getRoomById(facility.getRoomId()));
		}
		return facilityRepository.save(facility);
	}

	@Override
	public Facility updateFacility(Facility facility) {
		return facilityRepository.save(facility);
	}

	@Override
	public Facility getFacilityById(Integer facilityId) {
		return facilityRepository.getById(facilityId);
	}

	@Override
	public List<Facility> findAllFacility() {
		return facilityRepository.findAll();
	}

	@Override
	public Boolean deleteFacilityByid(Integer facilityId) {
		facilityRepository.deleteById(facilityId);
		return true;
	}

	
}
