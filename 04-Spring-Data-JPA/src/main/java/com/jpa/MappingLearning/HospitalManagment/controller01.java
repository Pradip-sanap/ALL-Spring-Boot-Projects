package com.jpa.MappingLearning.HospitalManagment;

import com.jpa.repository.DepartmentRepo;
import com.jpa.repository.DoctorRepo;
import com.jpa.repository.InsuranceRepo;
import com.jpa.repository.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class controller01 {
    private final InsuranceRepo insuranceRepo;
    private final PatientRepo patientRepo;

    private final DepartmentRepo departmentRepo;
    private final DoctorRepo doctorRepo;

    @GetMapping
    public void test(){
//        Optional<Insurance> insurance = insuranceRepo.findById(5l);
//        Insurance obj = insurance.get();
//
//        System.out.println(obj.getId());
//        System.out.println(obj.getPatient().getName());

//        Optional<Patient> patient = patientRepo.findById(4l);
//        System.out.println("Patient ->"+ patient.get().toString());
//
//        patient.get().getAppointments().forEach(appointment -> {
//            System.out.println("Patients appointment-> "+ appointment);
//            Docter docter = appointment.getDocter();
//            System.out.println("Doctor assign for appoitment -> "+docter);
//            System.out.println("--------------");
//        });


        Department department = new Department();
        department.setName("TimePass Doctors");

        Docter d1 = new Docter();
        d1.setName("Pradsdip");
        d1.setEmail("pradidp55@gmail.com");
        Docter d2 = new Docter();
        d2.setName("Pradisp");
        d2.setEmail("pradidpsss55s@gmail.com");
        doctorRepo.saveAll(List.of(d1, d2));


        department.setDoctors(Set.of(d1, d2));

        departmentRepo.save(department);
    }
}
