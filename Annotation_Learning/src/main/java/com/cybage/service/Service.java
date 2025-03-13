package com.cybage.service;

import com.cybage.repository.Repository;

public class Service {
	Repository repo;
	public Service(Repository r){
		repo = r;
	}
	public void add() {
		System.out.println("User data updated in service now saving to db.");
	}
}
