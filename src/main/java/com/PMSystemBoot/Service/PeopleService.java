package com.PMSystemBoot.Service;

import java.util.List;
import java.util.UUID;

import com.PMSystemBoot.Dto.PeopleDto;

public interface PeopleService {
	
	public PeopleDto SavepeopleDto(PeopleDto peopleDto);
	
	public PeopleDto GetPeopleById(UUID id);
	
	public List<PeopleDto> GetAllPeopleData();
	
	public PeopleDto UpdatePeople(UUID id, PeopleDto updatedPeople);
	
	public void DeletePeopleById(UUID id);

	
	


}
