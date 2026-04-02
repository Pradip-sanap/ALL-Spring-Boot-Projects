package com.jpa.service;

import com.jpa.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeeService{


    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }
}
