package com.niyonsaba.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niyonsaba.pma.dao.EmployeeRepository;
import com.niyonsaba.pma.dao.ProjectRepository;
import com.niyonsaba.pma.entities.Employee;
import com.niyonsaba.pma.entities.Project;

@Controller 
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		
		List<Employee> employees = employeeRepo.findAll();
		
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
		
	}
	
	@PostMapping(value="/save")
	public String createProject(Project project, Model model) {
//		this handle save data to the database
		proRepo.save(project);
		
//		use redirect to prevent duplicate submissions
		return "redirect:/projects";
		
	}
	
	@GetMapping("")
	public String displyHomePage(Model model) {
	
		List<Project> projects = proRepo.findAll();
		
		model.addAttribute("projectList", projects);
		return "projects/list-projects";
    }

}
