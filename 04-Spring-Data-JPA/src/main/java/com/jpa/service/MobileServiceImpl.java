package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.Mobile;
import com.jpa.repository.MobileRepository;

@Service
public class MobileServiceImpl {

	@Autowired
	MobileRepository repo;

	public Mobile saveMobile() {
		Mobile m1 = new Mobile("J222KK","Samsung", "S23", 70000, 10);
		return repo.save(m1);
	}

	public void saveAll() {
		List<Mobile> mobiles = List.of(
				new Mobile("J243Kg", "Apple", "iPhone 15", 120000, 5),
				new Mobile("J244KK", "OnePlus", "11R", 45000, 15)
		);
		repo.saveAll(mobiles);
		
//		repo.
	}
}
