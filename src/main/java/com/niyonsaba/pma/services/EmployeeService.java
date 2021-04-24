package com.niyonsaba.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niyonsaba.pma.dao.EmployeeRepository;

@Service
public class EmployeeService {
	// field Injection
	@Autowired
	EmployeeRepository employeeRepo;


//	Setter Injection
//	@Autowired
//	public void setEmployeeRepo(EmployeeRepository employeeRepo) {
//		this.employeeRepo = employeeRepo;
//	}
	
//	Constructor Injection
//	public EmployeeService(EmployeeRepository employeeRepo) {
//		super();
//		this.employeeRepo = employeeRepo;
//	}

	
	

}
