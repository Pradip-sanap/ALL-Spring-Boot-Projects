package com.jpa.repository;

import com.jpa.MappingLearning.HospitalManagment.Docter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Docter, Long> {
}
