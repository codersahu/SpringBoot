package com.PMSystemBoot.Dto;

import java.util.UUID;

public class PeopleDto {
	
	private UUID id;
	private String name;
	private String city;
	private String state;
	
	@Override
	public String toString() {
		return "PeopleDto [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + "]";
	}

	public PeopleDto(UUID id, String name, String city, String state) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
	}

	public PeopleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	

}
