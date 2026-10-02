package org.rodion.solution.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.rodion.solution.entity.Facility;
import org.rodion.solution.entity.Resident;
import org.rodion.solution.entity.Room;
import org.rodion.solution.model.FacilityModel;
import org.rodion.solution.model.ResidentModel;
import org.rodion.solution.model.RoomModel;

public class ApiConverter {

	public static Room getRoomJpaObject(RoomModel roomModel) {

		if (roomModel != null) {
			Room room = new Room();
			room.setId(roomModel.getId());
			room.setFloorNumber(roomModel.getFloorNumber());
			if ("yes".equalsIgnoreCase(roomModel.getIsBooked())) {
				room.setIsBooked(true);
			} else {
				room.setIsBooked(false);
			}
			room.setRoomFare(roomModel.getRoomFare());
			room.setRoomType(roomModel.getRoomType());
			room.setRoomNumber(roomModel.getRoomNumber());

			Integer facilityId = roomModel.getFacilityId();
			if (facilityId != null && facilityId != 0) {
				Facility facility = new Facility();
				facility.setId(facilityId);
				room.setFacility(facility);
			}
			return room;
		}
		return null;

	}

	public static RoomModel getRoomModelObject(Room room) {

		if (room != null) {
			RoomModel roomModel = new RoomModel();
			roomModel.setId(room.getId());
			roomModel.setFloorNumber(room.getFloorNumber());
			if (room.getIsBooked()) {
				roomModel.setIsBooked("Yes");
			} else {
				roomModel.setIsBooked("No");
			}
			roomModel.setRoomFare(room.getRoomFare());
			roomModel.setRoomType(room.getRoomType());
			roomModel.setRoomNumber(room.getRoomNumber());
			Facility facility = room.getFacility();
			if (facility != null) {
				roomModel.setFacilityId(facility.getId());
			}
			return roomModel;
		}
		return null;
	}

	public static List<RoomModel> getAllRoomModelObject(List<Room> roomList) {

		if (roomList != null && !roomList.isEmpty()) {
			List<RoomModel> roomModelList = new ArrayList<RoomModel>();
			for (Room room : roomList) {
				roomModelList.add(getRoomModelObject(room));
			}
			return roomModelList;
		}
		return null;
	}

	public static Resident getResidentJpaObject(ResidentModel residentModel) {

		if (residentModel != null) {
			Resident resident = new Resident();
			resident.setId(residentModel.getId());
			resident.setResidentAddress(residentModel.getResidentAddress());
			resident.setResidentIdProof(residentModel.getResidentIdProof());
			resident.setResidentName(residentModel.getResidentName());
			resident.setResidentPhoneNo(residentModel.getResidentPhoneNo());
			String checkInTime = residentModel.getCheckInTime();
			if (checkInTime != null && !checkInTime.isEmpty()) {
				LocalDateTime localDateTime = Util.strToDateTime(checkInTime);
				resident.setCheckinTime(localDateTime);
			}
			resident.setRoomIdList(residentModel.getRoomIdList());
			resident.setRoomId(residentModel.getRoomId());
			if(residentModel.getId() == null || residentModel.getId() == 0) {
				resident.setBookedDateTime(LocalDateTime.now());
				resident.setCheckinTime(LocalDateTime.now());
			}
			return resident;
		}
		return null;
	}

	public static Room getRoomObject(Integer roomId) {
		Room room = new Room();
		room.setId(roomId);
		return room;
	}

	public static ResidentModel getResidentModelObject(Resident resident) {

		if (resident != null) {
			ResidentModel residentModel = new ResidentModel();
			residentModel.setId(resident.getId());
			residentModel.setResidentAddress(resident.getResidentAddress());
			residentModel.setResidentIdProof(resident.getResidentIdProof());
			residentModel.setResidentName(resident.getResidentName());
			residentModel.setResidentPhoneNo(resident.getResidentPhoneNo());
			List<Room> roomList = resident.getRoomList();
			if(roomList != null && !roomList.isEmpty()) {
				for(Room room: roomList) {
					residentModel.setRoomId(room.getId());
					residentModel.setRoomType(room.getRoomType());
					residentModel.setRoomNumber(room.getRoomNumber());
				}
			}
			LocalDateTime bookedDateTime = resident.getBookedDateTime();
			if(bookedDateTime != null) {
				residentModel.setBookedDateTime(bookedDateTime.toString());
			}
			LocalDateTime checkinTime = resident.getCheckinTime();
			if(checkinTime != null) {
				residentModel.setCheckInTime(checkinTime.toString());
			}
			 LocalDateTime checkOutTime = resident.getCheckOutTime();
			 if(checkOutTime != null) {
				 residentModel.setCheckOutTime(checkOutTime.toString());
			 }
			return residentModel;
		}
		return null;
	}

	public static List<ResidentModel> getAllResidentModelObject(List<Resident> residentList) {

		if (residentList != null && !residentList.isEmpty()) {
			List<ResidentModel> residentModelList = new ArrayList<ResidentModel>();
			for (Resident resident : residentList) {
				residentModelList.add(getResidentModelObject(resident));
			}
			return residentModelList;
		}
		return null;
	}

	public static Facility getFacilityJpaObject(FacilityModel facilityModel) {

		if (facilityModel != null) {
			Facility facility = new Facility();
			facility.setId(facilityModel.getId());
			// facility.setBedRoom(facilityModel.getBedRoom());
			if ("yes".equalsIgnoreCase(facilityModel.getHasGizer())) {
				facility.setHasGizer(true);
			} else {
				facility.setHasGizer(false);
			}

			if ("yes".equalsIgnoreCase(facilityModel.getHasLift())) {
				facility.setHasLift(true);
			} else {
				facility.setHasLift(false);
			}
			if ("yes".equalsIgnoreCase(facilityModel.getHasPhone())) {
				facility.setHasPhone(true);
			} else {
				facility.setHasPhone(false);
			}
			if ("yes".equalsIgnoreCase(facilityModel.getHasTV())) {
				facility.setHasTV(true);
			} else {
				facility.setHasTV(false);
			}
			if ("yes".equalsIgnoreCase(facilityModel.getHasWIFI())) {
				facility.setHasWIFI(true);
			} else {
				facility.setHasWIFI(false);
			}
			if ("yes".equalsIgnoreCase(facilityModel.getHasAC())) {
				facility.setHasAC(true);
			} else {
				facility.setHasAC(false);
			}
			facility.setRoomIdList(facilityModel.getRoomIdList());
			facility.setRoomId(facilityModel.getRoomId());
			return facility;
		}
		return null;
	}

	public static FacilityModel getFacilityModelObject(Facility facility) {
		if (facility != null) {
			FacilityModel facilityModel = new FacilityModel();
			facilityModel.setId(facility.getId());
			// facilityModel.setBedRoom(facility.getBedRoom());
			if (facility.getHasGizer()) {
				facilityModel.setHasGizer("Yes");
			} else {
				facilityModel.setHasGizer("No");
			}
			if (facility.getHasLift()) {
				facilityModel.setHasLift("Yes");
			} else {
				facilityModel.setHasLift("No");
			}
			if (facility.getHasPhone()) {
				facilityModel.setHasPhone("Yes");
			} else {
				facilityModel.setHasPhone("No");
			}
			if (facility.getHasTV()) {
				facilityModel.setHasTV("Yes");
			} else {
				facilityModel.setHasTV("No");
			}
			if (facility.getHasWIFI()) {
				facilityModel.setHasWIFI("Yes");
			} else {
				facilityModel.setHasWIFI("No");
			}

			if (facility.getHasAC()) {
				facilityModel.setHasAC("Yes");
			} else {
				facilityModel.setHasAC("No");
			}
			List<Room> roomList = facility.getRoomList();
			if (roomList != null && !roomList.isEmpty()) {
				facilityModel.setRoomNumber(roomList.get(0).getRoomNumber());
			}
			return facilityModel;
		}
		return null;
	}

	public static List<FacilityModel> getAllFacilityModelObject(List<Facility> facilityList) {

		if (facilityList != null && !facilityList.isEmpty()) {
			List<FacilityModel> facilityModelList = new ArrayList<FacilityModel>();
			for (Facility facility : facilityList) {
				facilityModelList.add(getFacilityModelObject(facility));
			}
			return facilityModelList;
		}
		return null;
	}

}
