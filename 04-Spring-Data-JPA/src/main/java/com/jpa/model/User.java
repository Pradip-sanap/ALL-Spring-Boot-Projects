package com.jpa.model;

import java.time.LocalDate;

import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

//@Value
@Data
public class User {

	@NotNull(message = "Id cannot be null") 
	private Long id;
	
	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 50, message = "Name must be 3 - 50 char.")
	private String name;
	
	@Email(message = "Invalid email")
	private String email;
//	
	@Min(value = 18, message = "Age must greater than 18")
	@Max(value = 150, message = "Age must less than 150")
	private int age;
//	
	@Past(message = "Birthdate must be in past")
	private LocalDate birthDate;
//	
	@Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")	
	private String phone;
//	
	@PositiveOrZero(message = "Salary must be zero or positive")
	private double salary;
	

}
