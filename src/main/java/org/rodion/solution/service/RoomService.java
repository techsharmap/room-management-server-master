package org.rodion.solution.service;

import java.util.List;

import org.rodion.solution.entity.Room;

public interface RoomService {

	public Room addRoom(Room room);

	public Room updateRoom(Room room);

	public Room getRoomById(Integer roomId);
	
	public List<Room> findAllRoom();

	public Boolean deleteRoomById(Integer roomId);

	public List<Room> findAllRoomWithNullFacility();

	public List<Room> findAllWithoutBookedRoom();
}
