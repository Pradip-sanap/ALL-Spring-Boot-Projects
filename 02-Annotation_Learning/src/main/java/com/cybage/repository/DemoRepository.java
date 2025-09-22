package com.cybage.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entity.Product;

@Repository
public class DemoRepository
//extends JpaRepository<Product, Integer>
{
	public void print() {
		System.out.println("Repository called");
	}
}
