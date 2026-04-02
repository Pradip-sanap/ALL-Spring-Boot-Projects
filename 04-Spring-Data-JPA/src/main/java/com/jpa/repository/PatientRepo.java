package com.jpa.repository;

import com.jpa.MappingLearning.HospitalManagment.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
