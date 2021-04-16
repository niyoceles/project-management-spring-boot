package com.niyonsaba.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niyonsaba.pma.dao.ProjectRepository;
import com.niyonsaba.pma.entities.Project;

@Controller 
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository proRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		
		model.addAttribute("project", aProject);
		
		return "projects/new-project";
		
	}
	
	@PostMapping(value="/save")
	public String createProject(Project project, Model model) {
//		this handle save data to the database
//		proRepo.save(project);
		proRepo.save(project);
//		use redirect to prevent duplicate submissions
		return "redirect:/projects/new";
		
	}
	
	@GetMapping("")
	public String displyHomePage(Model model) {
	
		List<Project> projects = proRepo.findAll();
		
		model.addAttribute("projectList", projects);
		return "projects/list-projects";
    }

}
