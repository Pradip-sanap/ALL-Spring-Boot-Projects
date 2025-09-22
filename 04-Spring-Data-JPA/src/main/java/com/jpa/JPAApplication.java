package com.jpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.jpa.entity.Mobile;
import com.jpa.repository.MobileRepository;

@SpringBootApplication
public class JPAApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JPAApplication.class, args);

		MobileRepository repo = context.getBean(MobileRepository.class);

//		 Mobile m1 = new Mobile("SKU12345", "Samsung", "Galaxy S21", 799.99, 50);
//		 Mobile saveobj = repo.save(m1);
//		 System.out.println(saveobj);

		// Create a List to store Mobile objects
//		List<Mobile> mobiles = new ArrayList<>(); 
//		mobiles.add(new Mobile("SKU1001", "Apple", "iPhone 13", 999.99, 100));
//		mobiles.add(new Mobile("SKU1002", "Samsung", "Galaxy S22", 899.99, 150));
//		mobiles.add(new Mobile("SKU1003", "OnePlus", "OnePlus 9", 749.99, 75));
//		mobiles.add(new Mobile("SKU1004", "Google", "Pixel 6", 699.99, 60));
//		mobiles.add(new Mobile("SKU1005", "Xiaomi", "Mi 11", 599.99, 200));
//		
//		List<Mobile> saveAll = repo.saveAll(mobiles);
//		System.out.println(saveAll);
		
//		Optional<Mobile> mobile = repo.findById(2L);
//		mobile.ifPresent(obj -> System.out.println(obj));
		
//		List<Mobile> allById = repo.findAllById(List.of(1L,33L,53L, 63L));
//		System.out.println(allById);
		
//		List<Mobile> allMobiles = repo.findAll();
//		System.out.println(allMobiles);
		
//		long count = repo.count();
//		System.out.println(count);
		
//		long exist = 1L;
//		boolean existsById = repo.existsById(exist);
//		System.out.println(existsById);
		
//		Mobile m1 = new Mobile("SKU12345", "Samsung", "Galaxy S21", 799.99, 50);
//		m1.setId(1L);
//		repo.delete(m1);
//		System.out.println("Deleted");
		
//		repo.deleteById(2L);
//		repo.deleteAll();
//		repo.deleteAllById(List.of(2L,3L));
		
//		List<Mobile> sort = repo.findAll(Sort.by("brand", "price").ascending());
//		System.out.println(sort);
		
//		Page<Mobile> all = repo.findAll(PageRequest.of(0, 3, Sort.by("brand")));
//		System.out.println(all.getContent());
//		Page<Mobile> all1 = repo.findAll(PageRequest.of(1, 3, Sort.by("brand")));
//		System.out.println(all1.getContent());
//		Page<Mobile> all2 = repo.findAll(PageRequest.of(2, 3, Sort.by("brand")));
//		System.out.println(all2.getContent());
		
	}

}
