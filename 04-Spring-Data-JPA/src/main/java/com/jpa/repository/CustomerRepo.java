package com.jpa.repository;

import com.jpa.MappingLearning.OneToMany.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
