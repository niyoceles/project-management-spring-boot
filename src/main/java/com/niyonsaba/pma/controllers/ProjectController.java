package com.niyonsaba.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niyonsaba.pma.entities.Employee;
import com.niyonsaba.pma.entities.Project;
import com.niyonsaba.pma.services.EmployeeService;
import com.niyonsaba.pma.services.ProjectService;

@Controller 
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		
		List<Employee> employees = employeeService.getAll();
		
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
		
	}
	
	@PostMapping(value="/save")
	public String createProject(Project project) {
//		this handle save data to the database
		projectService.save(project);
		
//		use redirect to prevent duplicate submissions
		return "redirect:/projects";
		
	}
	
	@GetMapping("")
	public String displyHomePage(Model model) {
	
		List<Project> projects = projectService.getAll();
		
		model.addAttribute("projectList", projects);
		return "projects/list-projects";
    }

}
