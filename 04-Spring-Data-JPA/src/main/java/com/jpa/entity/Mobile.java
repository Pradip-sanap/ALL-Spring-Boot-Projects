package com.jpa.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
		name = "mobiles",
		schema = "testdb",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "sku"),
				@UniqueConstraint(columnNames = "model")
		}
)
@Data 
@NoArgsConstructor
public class Mobile {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "stock_keeping_unit", nullable = false)
	private String sku;
	
    private String brand;
    
    @Column(nullable = false)
    private String model;
    
    private double price;
    
    @Column()
    private int stock;
    
    @CreationTimestamp
    private LocalDateTime dateCreated;
    
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    public Mobile(String sku,String brand, String model, double price, int stock) {
    	this.sku = sku;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
    }
}
