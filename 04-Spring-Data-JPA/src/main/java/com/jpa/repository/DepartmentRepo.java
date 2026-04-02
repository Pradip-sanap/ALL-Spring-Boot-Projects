package com.jpa.repository;

import com.jpa.MappingLearning.HospitalManagment.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,  Long> {
}
