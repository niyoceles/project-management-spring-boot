package com.niyonsaba.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niyonsaba.pma.dao.EmployeeRepository;
import com.niyonsaba.pma.dto.EmployeeProject;
import com.niyonsaba.pma.entities.Employee;

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

	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
		
	}
	
	public List<Employee> getAll() {
		return employeeRepo.findAll();
		
	}
	
	public List<EmployeeProject> getEmployeeProject() {
		return employeeRepo.employeeProjects();
		
	}
	
	

}
