package com.niyonsaba.pma.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.niyonsaba.pma.entities.Employee;

import com.niyonsaba.pma.dao.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApiController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping
	public Iterable<Employee> getEmployees(){
		return employeeRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long id){
		return employeeRepo.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@RequestBody Employee employee){
		return employeeRepo.save(employee);
	}
	
//	
////	PUT updates all entire record
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee update(@RequestBody Employee employee){
		return employeeRepo.save(employee);
	}
	
////	PATCH updates ANY WHERE YOU WANT BUT NOT ALL ENTIRE RECORD
	@PatchMapping(path="/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee patchEmployee){
		Employee emp = employeeRepo.findById(id).get();
		
		if(patchEmployee.getEmail() != null) {
			emp.setEmail(patchEmployee.getEmail());
		}
		if(patchEmployee.getFirstName() != null) {
			emp.setEmail(patchEmployee.getFirstName());
		}
		if(patchEmployee.getLastName() != null) {
			emp.setEmail(patchEmployee.getLastName());
		}
		return employeeRepo.save(emp);
	}

}
