package org.rodion.solution.model;

import java.util.List;

public class ResidentModel {
	private Integer id;
	private String residentIdProof;
	private String residentName;;
	private String residentAddress;
	private String residentPhoneNo;
	private String checkInTime;
	private String checkOutTime;
	private List<Integer> roomIdList;
	private Integer roomId;
	private String bookedDateTime;
	private String roomType;
	private Integer roomNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResidentIdProof() {
		return residentIdProof;
	}

	public void setResidentIdProof(String residentIdProof) {
		this.residentIdProof = residentIdProof;
	}

	public String getResidentName() {
		return residentName;
	}

	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}

	public String getResidentAddress() {
		return residentAddress;
	}

	public void setResidentAddress(String residentAddress) {
		this.residentAddress = residentAddress;
	}

	public String getResidentPhoneNo() {
		return residentPhoneNo;
	}

	public void setResidentPhoneNo(String residentPhoneNo) {
		this.residentPhoneNo = residentPhoneNo;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
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

	public String getBookedDateTime() {
		return bookedDateTime;
	}

	public void setBookedDateTime(String bookedDateTime) {
		this.bookedDateTime = bookedDateTime;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

}
