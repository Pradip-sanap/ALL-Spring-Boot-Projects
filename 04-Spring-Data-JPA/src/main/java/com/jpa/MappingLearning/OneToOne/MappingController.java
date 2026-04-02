package com.jpa.MappingLearning.OneToOne;

import com.jpa.repository.AddressRepository;
import com.jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapping")
@RequiredArgsConstructor
public class MappingController {

    private final AddressRepository addressRepo;
    private final EmployeeRepository employeeRepo;


    @GetMapping()
    public void foo(){
        Employee emp = new Employee();
        emp.setName("Kevin");

        Address addr = new Address();
        addr.setCity("London");

//        emp.setAddress(addr);
        addr.setEmployee(emp);

//        Employee saveEmp = employeeRepo.save(emp);
        Address saveAddr = addressRepo.saveAndFlush(addr);

//        System.out.println(saveEmp);
        System.out.println(saveAddr);
    }





}
