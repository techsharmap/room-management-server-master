package org.rodion.solution.model;

import java.util.List;

public class FacilityModel {

	private Integer id;
	// private Integer bedRoom;
	private String hasTV;
	private String hasWIFI;
	private String hasGizer;
	private String hasPhone;
	private String hasLift;
	private String hasAC;
	private List<Integer> roomIdList;
	private Integer roomId;
	private Integer roomNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Integer getBedRoom() {
//		return bedRoom;
//	}
//
//	public void setBedRoom(Integer bedRoom) {
//		this.bedRoom = bedRoom;
//	}

	public String getHasTV() {
		return hasTV;
	}

	public void setHasTV(String hasTV) {
		this.hasTV = hasTV;
	}

	public String getHasWIFI() {
		return hasWIFI;
	}

	public void setHasWIFI(String hasWIFI) {
		this.hasWIFI = hasWIFI;
	}

	public String getHasGizer() {
		return hasGizer;
	}

	public void setHasGizer(String hasGizer) {
		this.hasGizer = hasGizer;
	}

	public String getHasPhone() {
		return hasPhone;
	}

	public void setHasPhone(String hasPhone) {
		this.hasPhone = hasPhone;
	}

	public String getHasLift() {
		return hasLift;
	}

	public void setHasLift(String hasLift) {
		this.hasLift = hasLift;
	}

	public String getHasAC() {
		return hasAC;
	}

	public void setHasAC(String hasAC) {
		this.hasAC = hasAC;
	}

	public List<Integer> getRoomIdList() {
		return roomIdList;
	}

	public void setRoomIdList(List<Integer> roomIdList) {
		this.roomIdList = roomIdList;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

}
