package com.cybage.service;

import org.springframework.stereotype.Service;

@Service("service_v2")
public class DemoServiceImplV2 implements DemoService {

	@Override
	public boolean print() {
		System.out.println("V2 service call");
		return false;
	}

}
