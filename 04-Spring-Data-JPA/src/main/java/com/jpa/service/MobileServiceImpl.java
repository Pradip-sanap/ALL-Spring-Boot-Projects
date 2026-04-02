package com.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.Mobile;
import com.jpa.repository.MobileRepository;

@Service
public class MobileServiceImpl {

    @Autowired
    MobileRepository repo;

//	public Mobile saveMobile() {
//
//		return repo.save(m1);
//	}
//
//	public void saveAll() {
//		repo.saveAll(mobiles);
//
    /// /		repo.
//	}


    public void jpa_Default_Methods() {

//		save();
//		saveMultiple();

//		Optional<Mobile> result1 = repo.findById(2l);
//		System.out.println(result1.get());
//		System.out.println(result1);

//		Optional<Mobile> result2 = repo.findById(123l);
//		try{
//			System.out.println("Log 1");
//			System.out.println(result2.get());
//			System.out.println("Log 2");
//			System.out.println(result2.orElseThrow(()-> new RuntimeException("Not data found")));
//
//		}catch (Exception e){
//			System.out.println("Inside catch ");
//			System.out.println(e.getMessage());
//			System.out.println(e);
//		}


	}

	void save(){

		Mobile m1 = new Mobile("J222KK", "Samsung", "S23", 70000, 10);
		Mobile mobile = repo.saveAndFlush(m1);
		System.out.println(mobile);
	}

	void saveMultiple(){
		List<Mobile> mobiles = List.of(
				new Mobile("J243Kg", "Apple", "iPhone 15", 120000, 5),
				new Mobile("J244KK", "OnePlus", "11R", 45000, 15)
		);

		List<Mobile> mobiles1 = repo.saveAllAndFlush(mobiles);
		System.out.println(mobiles1);
	}
}
