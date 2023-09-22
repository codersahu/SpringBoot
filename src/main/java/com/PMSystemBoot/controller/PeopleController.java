package com.PMSystemBoot.controller;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PMSystemBoot.Dto.PeopleDto;
import com.PMSystemBoot.Service.PeopleService;

@RestController
@RequestMapping("/api/peopleInfo")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@PostMapping("/save")
	public ResponseEntity<?> savePeopleData(@RequestBody PeopleDto peopleDto)
	{
		PeopleDto peplDto=peopleService.SavepeopleDto(peopleDto);
		return new ResponseEntity<>(peplDto,HttpStatus.CREATED);
				
	}
	
	@GetMapping("/getpeople/{id}")
	public ResponseEntity<?> GetPeopleById(@PathVariable UUID id)
	{
		PeopleDto peopleDto = peopleService.GetPeopleById(id);
		return new ResponseEntity<>(peopleDto,HttpStatus.FOUND);
	}
	
	@GetMapping("/getalldata")
	public ResponseEntity<List<PeopleDto>> getAllPeopleData()
	{
		List<PeopleDto> getAllPeopleData = peopleService.GetAllPeopleData();
		return new ResponseEntity<>(getAllPeopleData, HttpStatus.OK);
	}
	
	@PutMapping("/newupdated/{PeopleId}")
	public ResponseEntity<?> UpdatePeopleById(@PathVariable UUID PeopleId, @RequestBody PeopleDto updatedPeople)
	{
		PeopleDto peopleDto = peopleService.UpdatePeople(PeopleId, updatedPeople);
		return new ResponseEntity<>(peopleDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<?> DeletePeopleById(@PathVariable UUID Id)
	{
		peopleService.DeletePeopleById(Id);
		return ResponseEntity.ok("Id deleted successfully!!.");
	}
	
	
	

}
