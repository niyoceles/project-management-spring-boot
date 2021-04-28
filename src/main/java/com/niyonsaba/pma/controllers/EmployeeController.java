package com.niyonsaba.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niyonsaba.pma.entities.Employee;
import com.niyonsaba.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model, Employee employee) {
		
		Employee anEmployee = new Employee();
		
		model.addAttribute("employee", anEmployee);
		
		return "employees/new-employee";
		
	}
	
	@PostMapping("/save")
	public String createEmployee(@Valid Employee employee, BindingResult bindingResult , Model model) {
		
		if (bindingResult.hasErrors()) {
			return "employees/new-employee";
		}
		
		employeeService.save(employee);
		
		return "redirect:/employees";
	}
	
	@GetMapping("")
	public String displyHomePage(Model model) {
	
		List<Employee> employees = employeeService.getAll();
		
		model.addAttribute("employeesList", employees);
		return "employees/list-employees";
    }
	
	@GetMapping("/update")
	public String displyUpdateEmployee(@RequestParam("id") long theId, Model model) {
	
        Employee employee = employeeService.findById(theId);
		
		
		model.addAttribute("employee", employee);
		return "employees/update-employee";
    }
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long theId, Model model) {
		
		Employee theEmp = employeeService.findById(theId);
	
         employeeService.delete(theEmp);
//		
//		model.addAttribute("employee", employee);
		return "redirect:/employees";
    }

}
