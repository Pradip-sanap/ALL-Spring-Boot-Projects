package com.jpa.repository;

import com.jpa.MappingLearning.HospitalManagment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}
