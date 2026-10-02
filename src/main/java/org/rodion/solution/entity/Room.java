package org.rodion.solution.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM")
public class Room implements Serializable {

	private static final long serialVersionUID = -5931672617291013132L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "FLOOR_NUMBER")
	private Integer floorNumber;

	@Column(name = "ROOM_NUMBER")
	private Integer roomNumber;

	@Column(name = "IS_BOOKED")
	private Boolean isBooked;

	@Column(name = "ROOM_TYPE")
	private String roomType;

	@Column(name = "ROOM_FARE")
	private BigDecimal roomFare;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "roomList")
	private List<Resident> residentList;

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

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
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

	public List<Resident> getResidentList() {
		return residentList;
	}

	public void setResidentList(List<Resident> residentList) {
		this.residentList = residentList;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

}
