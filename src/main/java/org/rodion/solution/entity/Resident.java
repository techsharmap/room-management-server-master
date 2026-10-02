package org.rodion.solution.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "RESIDENT")
public class Resident implements Serializable {

	private static final long serialVersionUID = -7121393151190460613L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "RESIDENT_ID_PROOF")
	private String residentIdProof;

	@Column(name = "RESIDENT_NAME")
	private String residentName;

	@Column(name = "RESIDENT_ADDRESS")
	private String residentAddress;

	@Column(name = "RESIDENT_PHONE_NUMBER")
	private String residentPhoneNo;

	@Column(name = "CHECK_IN_TIME", updatable = false)
	private LocalDateTime checkinTime;

	@Column(name = "CHECK_OUT_TIME", updatable = true, insertable = false)
	private LocalDateTime checkOutTime;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "resident_room", joinColumns = @JoinColumn(name = "resident_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"))
	private List<Room> roomList;
	
	@Column(name = "BOOKED_DATE")
	private LocalDateTime bookedDateTime;

	@Column(name = "DAY_COUNT")
	private String dayCount;
	@Transient
	private List<Integer> roomIdList;

	@Transient
	private Integer roomId;

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

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public List<Integer> getRoomIdList() {
		return roomIdList;
	}

	public void setRoomIdList(List<Integer> roomIdList) {
		this.roomIdList = roomIdList;
	}

	public LocalDateTime getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(LocalDateTime checkinTime) {
		this.checkinTime = checkinTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public LocalDateTime getBookedDateTime() {
		return bookedDateTime;
	}

	public void setBookedDateTime(LocalDateTime bookedDateTime) {
		this.bookedDateTime = bookedDateTime;
	}

	public String getDayCount() {
		return dayCount;
	}

	public void setDayCount(String dayCount) {
		this.dayCount = dayCount;
	}

	public void addRoom(Room room) {

		if (roomList == null || roomList.isEmpty()) {
			roomList = new ArrayList<Room>();
		}
		roomList.add(room);
	}
}
