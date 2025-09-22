package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.model.Employee;
import com.jpa.service.EmployeeService;

// @Controller + @ResponseBody = @RestController
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	 
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public String getEmployee(@PathVariable("id") Long id) {
		return "Get Path mapping : " + id;
	}	
	
	@DeleteMapping("/emp")
	public String deleteEmployee(
			@RequestParam("departmentId") Long departmentId,
            @RequestParam("name") String name
    ) {
		return "Department ID: " + departmentId + ", Employee Name: " + name;
	}
	
	@PostMapping("/employee")
	public String saveEmployee(@RequestBody Employee employee) {
		return "Saving new Employee Details in DB:" + employee;
	}
	
	
	//---------------------------------------------------
	@Value("${app.name: Employee Tracker}")
	private String appName;
	
	@Value("${app.version: Beta V1.1.0}")
	private String version;
	
	@GetMapping("/version")
	public String getAppDetails() {
		return appName +" & "+ version;
	}
	
	@PutMapping("/employee/{age}/{name}")
	public Employee updatedEmployee(
			@PathVariable("age") Long age,
			@PathVariable("name") String name,
			@RequestBody Employee employee
	) {
		employee.setAge(age);
		employee.setName(name);
		return employee;
	}
	
	
	
	
}
