package com.jpa.MappingLearning.OneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    // Owning side: Address contains the foreign key
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")  // This is the foreign key
    private Employee employee;

}