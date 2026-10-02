package org.rodion.solution.model;

import java.math.BigDecimal;

public class RoomModel {

	private Integer id;
	private Integer floorNumber;
	private Integer roomNumber;
	private String isBooked;
	private String roomType;
	private BigDecimal roomFare;
	private Integer facilityId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(String isBooked) {
		this.isBooked = isBooked;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public BigDecimal getRoomFare() {
		return roomFare;
	}

	public void setRoomFare(BigDecimal roomFare) {
		this.roomFare = roomFare;
	}

	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

}
