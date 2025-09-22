package com.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Employee {
	
	@JsonProperty("full_name")
	private String name;
	@JsonIgnore
	private Long age;
	private String location;
	private String email;
	private String department;

}
