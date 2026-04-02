package com.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
public class Employee {
	
	@JsonProperty("full_name")
	private String name;
	@JsonIgnore
	private Long age;
	private String location;
	private String email;
	private String department;

}
