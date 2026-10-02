package org.rodion.solution.repository;

import org.rodion.solution.entity.Resident;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
	
	@Query("SELECT R FROM RESIDENT r WHERE r.id := residentId")
	public Resident getResidentById(@Param(value = "residentId") Integer residentId);
	
}
