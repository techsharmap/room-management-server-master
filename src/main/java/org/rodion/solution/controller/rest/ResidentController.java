package org.rodion.solution.controller.rest;

import java.util.List;

import org.rodion.solution.controller.BaseController;
import org.rodion.solution.controller.ResponseMessage;
import org.rodion.solution.entity.Resident;
import org.rodion.solution.model.ResidentModel;
import org.rodion.solution.service.ResidentService;
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
@RequestMapping(value = "/resident")
@CrossOrigin(value = Constant.uiBaseUrl)
public class ResidentController extends BaseController {

	@Autowired
	private ResidentService residentService;

	@PostMapping(value = "/add-resident")
	public ResponseEntity<?> addResident(@RequestBody ResidentModel residentModel) {
		
		ResponseMessage responseMessage = new ResponseMessage();
		Resident resident = ApiConverter.getResidentJpaObject(residentModel);
		residentService.addResident(resident);
		responseMessage.setStatus(true);
		if (residentModel.getId() == null || residentModel.getId() == 0) {
			responseMessage.setMessage("Resident added successfully.");
		} else {
			responseMessage.setMessage("Resident updated successfully.");
		}

		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-resident-by-id/{residentId}")
	public ResponseEntity<?> getResidentById(@PathVariable("residentId") Integer residentId) {
		
		ResponseMessage responseMessage = new ResponseMessage();
		Resident resident = residentService.getResidentById(residentId);
		responseMessage.setStatus(true);
		if (resident != null) {
			ResidentModel residentModel = ApiConverter.getResidentModelObject(resident);
			responseMessage.setData(residentModel);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/find-all-resident")
	public ResponseEntity<?> findAllResident() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<Resident> residentList = residentService.findAllResident();
		responseMessage.setStatus(true);
		if (residentList != null && !residentList.isEmpty()) {
			List<ResidentModel> residentModelList = ApiConverter.getAllResidentModelObject(residentList);
			responseMessage.setData(residentModelList);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/delete-resident-by-id/{residentId}")
	public ResponseEntity<?> deleteResidentById(@PathVariable("residentId") Integer residentId) {
		ResponseMessage responseMessage = new ResponseMessage();
		Boolean isDeleted = residentService.deleteResidentById(residentId);
		responseMessage.setStatus(true);
		if (isDeleted) {
			responseMessage.setMessage("Resident deleted successfully.");
		}
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/check-out-resident/{residentId}")
	public ResponseEntity<?> checkOutResidentById(@PathVariable("residentId") Integer residentId) {
		ResponseMessage responseMessage = new ResponseMessage();
		Boolean isDeleted = residentService.checkOutResidentById(residentId);
		responseMessage.setStatus(true);
		if (isDeleted) {
			responseMessage.setMessage("Resident check out successfully.");
		}
		return sendResponse(responseMessage);
	}
	

}
