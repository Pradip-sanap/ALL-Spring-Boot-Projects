package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.cybage.repository.DemoRepository;

@Service("service_v1")
//@Primary
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	DemoRepository demoRepository;
	
	
	public boolean print() {
		System.out.println("Service called");
		demoRepository.print();
		return true;
	}
}
