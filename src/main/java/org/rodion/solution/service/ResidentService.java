package org.rodion.solution.service;

import java.util.List;

import org.rodion.solution.entity.Resident;

public interface ResidentService {

	public Resident addResident(Resident resident);

	public Resident updateResident(Resident resident);

	public Resident getResidentById(Integer residentId);

	public List<Resident> findAllResident();

	public Boolean deleteResidentById(Integer residentId);

	public Boolean checkOutResidentById(Integer residentId);
}
