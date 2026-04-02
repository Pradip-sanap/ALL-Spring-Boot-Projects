package com.jpa.repository;

import com.jpa.MappingLearning.OneToOne.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
