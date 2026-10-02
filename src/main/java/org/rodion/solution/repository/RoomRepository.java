package org.rodion.solution.repository;

import java.util.List;

import org.rodion.solution.entity.Room;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Integer> {

	@Query("SELECT * FROM ROOM r WHERE r.id := roomId")
	public Room getRoomById(@Param(value = "roomId") Integer roomId);

	@Query("SELECT r FROM ROOM r WHERE r.isBooked :=isBooked")
	public List<Room> findByIsBooked(@Param(value = "isBooked") Boolean isBooked);

}
