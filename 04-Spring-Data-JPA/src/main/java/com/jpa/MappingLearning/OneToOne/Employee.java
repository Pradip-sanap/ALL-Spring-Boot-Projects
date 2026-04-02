package com.jpa.MappingLearning.OneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Inverse side: Employee doesn't own the relationship
    @OneToOne(mappedBy = "employee")
    private Address address;

    // Getters and setters
}
