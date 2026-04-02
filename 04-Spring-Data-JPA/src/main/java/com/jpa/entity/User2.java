package com.jpa.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "User_Table_2",
        schema = "public",
        catalog = "testdb",
        indexes = {
                @Index(name = "idx_name", columnList = "username")
        }
)
public class User2 {

    @Id
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 50 )
    private String name;

    @Column(name = "User_emails",nullable = false, length = 100, unique = true )
    private String email;

    @Column(precision = 5, scale = 3, nullable = false)
    private BigDecimal salary;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime joiningDate;

    @LastModifiedDate
    private LocalDateTime lastProfileUpdate;

    // Getters and Setters
}