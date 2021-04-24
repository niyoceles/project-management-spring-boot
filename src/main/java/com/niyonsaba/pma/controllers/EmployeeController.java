package com.niyonsaba.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niyonsaba.pma.dao.EmployeeRepository;
import com.niyonsaba.pma.entities.Employee;
import com.niyonsaba.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepo;
	
	EmployeeService employeeService;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee anEmployee = new Employee();
		
		model.addAttribute("employee", anEmployee);
		
		return "employees/new-employee";
		
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		
		employeeRepo.save(employee);
		
		return "redirect:/employees/new";
	}
	
	@GetMapping("")
	public String displyHomePage(Model model) {
	
		List<Employee> employees = employeeRepo.findAll();
		
		model.addAttribute("employeesList", employees);
		return "employees/list-employees";
    }

}
