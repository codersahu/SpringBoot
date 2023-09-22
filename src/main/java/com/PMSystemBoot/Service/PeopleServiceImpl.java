package com.PMSystemBoot.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PMSystemBoot.Dto.PeopleDto;
import com.PMSystemBoot.Entity.PeopleEntity;
import com.PMSystemBoot.Exception.ResourceNotFoundException;
import com.PMSystemBoot.Repository.PeopleRepository;
@Service
public class PeopleServiceImpl implements PeopleService {

	@Autowired
private PeopleRepository peopleRepo;

	@Override
	public PeopleDto SavepeopleDto(PeopleDto peopleDto) {
		PeopleEntity peopleEntity = new PeopleEntity();
		peopleEntity.setName(peopleDto.getName());
		peopleEntity.setCity(peopleDto.getCity());
		peopleEntity.setState(peopleDto.getState());
		peopleRepo.save(peopleEntity);
		peopleDto.setId(peopleEntity.getId());
		return peopleDto;
	}

	@Override
	public PeopleDto GetPeopleById(UUID PeopleId) {
		PeopleEntity peopleEntity = peopleRepo.findById(PeopleId).orElseThrow(()-> 
		new ResourceNotFoundException("People is not exists with the given people id"+PeopleId));
		PeopleDto peopleDto=new PeopleDto();
		peopleDto.setName(peopleEntity.getName());
		peopleDto.setCity(peopleEntity.getCity());
		peopleDto.setState(peopleEntity.getState());
		peopleDto.setId(peopleEntity.getId());
		return peopleDto ;
	}
	
	@Override
	public List<PeopleDto> GetAllPeopleData() 
	{
		List<PeopleEntity> Allpeopledata = peopleRepo.findAll();
		List<PeopleDto>dtoList = new ArrayList();
		Allpeopledata.forEach(e->
		{
			PeopleDto peopleDto = new PeopleDto();
			peopleDto.setId(e.getId());
			peopleDto.setName(e.getName());
			peopleDto.setCity(e.getCity());
			peopleDto.setState(e.getState());
			dtoList.add(peopleDto);
		});
		return dtoList;
	}

	@Override
	public PeopleDto UpdatePeople(UUID PeopleId, PeopleDto updatedPeople) {
		PeopleEntity peopleEntity = peopleRepo.findById(PeopleId).orElseThrow(()-> 
		new ResourceNotFoundException("People id is not available for the given people id : "+PeopleId));
		
		peopleEntity.setName(updatedPeople.getName());
		peopleEntity.setCity(updatedPeople.getCity());
		peopleEntity.setState(updatedPeople.getState());
		
		PeopleEntity updatedPepl = peopleRepo.save(peopleEntity);
		
		updatedPeople.setName(updatedPepl.getName());
		updatedPeople.setCity(updatedPepl.getCity());
		updatedPeople.setState(updatedPepl.getState());
		updatedPeople.setId(updatedPepl.getId());
		
		return updatedPeople;
	}

	@Override
	public void DeletePeopleById(UUID id) {
		peopleRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("People id is not available for the given id : "+id));
		peopleRepo.deleteById(id);
	}
	
	
	
}
