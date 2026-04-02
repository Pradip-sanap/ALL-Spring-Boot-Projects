package com.jpa.repository;

import com.jpa.MappingLearning.OneToMany.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
