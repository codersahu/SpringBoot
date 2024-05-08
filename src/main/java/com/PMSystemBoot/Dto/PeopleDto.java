package com.PMSystemBoot.Dto;

import java.util.UUID;

//We are using dto class like for example if we have login page so there we will pass in the body is password and username so for that we will create the dto class for this where only password and username variables are available and getter setter are availabe for calling this claas we use getter setter in any other class to add the data from the database inside it,so for creating this if someone checking our code so they can easily understand like this dto is usefull for login only no other varaibles are available inside the dto class but inside our login entity some more variables are available like creator id, user phone no etc but we dont need this data for login that is why we are creating a dto class for easy to understand and another thing is hiding the another data like phone no at all which is a part of data hiding abstraction this is for also important for security purpose that is why also we are using dto class.

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
