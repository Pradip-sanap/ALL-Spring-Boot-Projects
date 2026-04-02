package com.jpa.MappingLearning.OneToMany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "customer_id")  // Foreign key
    private Customer customer;


    Order(String name){
        this.description = name;
    }
}
