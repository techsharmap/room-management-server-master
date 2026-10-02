package org.rodion.solution.controller.rest;

import java.util.List;

import org.rodion.solution.controller.BaseController;
import org.rodion.solution.controller.ResponseMessage;
import org.rodion.solution.entity.Facility;
import org.rodion.solution.model.FacilityModel;
import org.rodion.solution.service.FacilityService;
import org.rodion.solution.util.ApiConverter;
import org.rodion.solution.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/facility")
@CrossOrigin(value = Constant.uiBaseUrl)
public class FacilityController extends BaseController {

	@Autowired
	private FacilityService facilityService;

	@PostMapping(value = "/add-facility")
	public ResponseEntity<?> addFacility(@RequestBody FacilityModel facilityModel) {

		ResponseMessage responseMessage = new ResponseMessage();
		Facility facility = ApiConverter.getFacilityJpaObject(facilityModel);
		facilityService.addFacility(facility);
		responseMessage.setStatus(true);
		if (facilityModel.getId() == null || facilityModel.getId() == 0) {
			responseMessage.setMessage("Facility added successfully.");
		} else {
			responseMessage.setMessage("Facility updated successfully.");
		}

		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-facility-by-id/{facilityId}")
	public ResponseEntity<?> getFacilityById(@PathVariable("facilityId") Integer facilityId) {

		ResponseMessage responseMessage = new ResponseMessage();
		Facility facility = facilityService.getFacilityById(facilityId);
		responseMessage.setStatus(true);
		if (facility != null) {
			FacilityModel facilityModel = ApiConverter.getFacilityModelObject(facility);
			responseMessage.setData(facilityModel);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/find-all-facility")
	public ResponseEntity<?> findAllFacility() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<Facility> facilityList = facilityService.findAllFacility();
		responseMessage.setStatus(true);
		if (facilityList != null && !facilityList.isEmpty()) {
			List<FacilityModel> facilityModellList = ApiConverter.getAllFacilityModelObject(facilityList);
			responseMessage.setData(facilityModellList);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/delete-facility-by-id/{facilityId}")
	public ResponseEntity<?> deleteResidentById(@PathVariable("facilityId") Integer facilityId) {
		ResponseMessage responseMessage = new ResponseMessage();
		Boolean isDeleted = facilityService.deleteFacilityByid(facilityId);
		responseMessage.setStatus(true);
		if (isDeleted) {
			responseMessage.setMessage("Facility deleted successfully.");
		}
		return sendResponse(responseMessage);
	}

}
