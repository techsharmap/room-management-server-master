package org.rodion.solution.controller.rest;

import java.util.List;

import org.rodion.solution.controller.BaseController;
import org.rodion.solution.controller.ResponseMessage;
import org.rodion.solution.entity.Room;
import org.rodion.solution.model.RoomModel;
import org.rodion.solution.service.RoomService;
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
@RequestMapping(value = "/room")
@CrossOrigin(value = Constant.uiBaseUrl)
public class RoomController extends BaseController {

	@Autowired
	private RoomService roomService;

	@PostMapping(value = "/add-room")
	public ResponseEntity<?> addRoom(@RequestBody RoomModel roomModel) {
		ResponseMessage responseMessage = new ResponseMessage();
		Room room = ApiConverter.getRoomJpaObject(roomModel);
		roomService.addRoom(room);
		responseMessage.setStatus(true);
		if (roomModel.getId() == null || roomModel.getId() == 0) {
			responseMessage.setMessage("Room added successfully.");
		} else {
			responseMessage.setMessage("Room updated successfully.");
		}

		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-room-by-id/{roomId}")
	public ResponseEntity<?> getRoomById(@PathVariable("roomId") Integer roomId) {
		ResponseMessage responseMessage = new ResponseMessage();
		Room room = roomService.getRoomById(roomId);
		responseMessage.setStatus(true);
		if (room != null) {
			RoomModel roomModel = ApiConverter.getRoomModelObject(room);
			responseMessage.setData(roomModel);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/find-all-room")
	public ResponseEntity<?> findAllRoom() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<Room> roomList = roomService.findAllRoom();
		responseMessage.setStatus(true);
		if (roomList != null && !roomList.isEmpty()) {
			List<RoomModel> roomModelList = ApiConverter.getAllRoomModelObject(roomList);
			responseMessage.setData(roomModelList);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/delete-room- by-id/{roomId}")
	public ResponseEntity<?> deleteRoomById(@PathVariable("roomId") Integer roomId) {
		ResponseMessage responseMessage = new ResponseMessage();
		Boolean isDeleted = roomService.deleteRoomById(roomId);
		if (isDeleted) {
			responseMessage.setMessage("Room deleted successfully.");
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/find-all-room-with-null-facility")
	public ResponseEntity<?> findAllRoomWithNullFacility() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<Room> roomList = roomService.findAllRoomWithNullFacility();
		responseMessage.setStatus(true);
		if (roomList != null && !roomList.isEmpty()) {
			List<RoomModel> roomModelList = ApiConverter.getAllRoomModelObject(roomList);
			responseMessage.setData(roomModelList);
		}
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/find-all-without-booked-room")
	public ResponseEntity<?> findAllWithoutBookedRoom() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<Room> roomList = roomService.findAllWithoutBookedRoom();
		responseMessage.setStatus(true);
		if (roomList != null && !roomList.isEmpty()) {
			List<RoomModel> roomModelList = ApiConverter.getAllRoomModelObject(roomList);
			responseMessage.setData(roomModelList);
		}
		return sendResponse(responseMessage);
	}

}
