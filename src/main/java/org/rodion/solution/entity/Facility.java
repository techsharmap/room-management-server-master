package org.rodion.solution.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "FACILITY")
public class Facility implements Serializable {

	private static final long serialVersionUID = 8590285851399242731L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "BED_ROOM")
	private Integer bedRoom;

	@Column(name = "HAS_TV")
	private Boolean hasTV;

	@Column(name = "HAS_WIFI")
	private Boolean hasWIFI;

	@Column(name = "HAS_GIZER")
	private Boolean hasGizer;

	@Column(name = "HAS_PHONE")
	private Boolean hasPhone;

	@Column(name = "HASH_LIFT")
	private Boolean hasLift;
	
	@Column(name = "HASH_AC")
	private Boolean hasAC;
	
	@OneToMany(mappedBy = "facility", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Room> roomList;
	
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

	public Integer getBedRoom() {
		return bedRoom;
	}

	public void setBedRoom(Integer bedRoom) {
		this.bedRoom = bedRoom;
	}

	public Boolean getHasTV() {
		return hasTV;
	}

	public void setHasTV(Boolean hasTV) {
		this.hasTV = hasTV;
	}

	public Boolean getHasWIFI() {
		return hasWIFI;
	}

	public void setHasWIFI(Boolean hasWIFI) {
		this.hasWIFI = hasWIFI;
	}

	public Boolean getHasGizer() {
		return hasGizer;
	}

	public void setHasGizer(Boolean hasGizer) {
		this.hasGizer = hasGizer;
	}

	public Boolean getHasPhone() {
		return hasPhone;
	}

	public void setHasPhone(Boolean hasPhone) {
		this.hasPhone = hasPhone;
	}

	public Boolean getHasLift() {
		return hasLift;
	}

	public void setHasLift(Boolean hasLift) {
		this.hasLift = hasLift;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public Boolean getHasAC() {
		return hasAC;
	}

	public void setHasAC(Boolean hasAC) {
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

	public void addRoom(Room room) {
		if (roomList == null || roomList.isEmpty()) {
			roomList = new ArrayList<Room>();
		}
		roomList.add(room);
		room.setFacility(this);
	}

}
