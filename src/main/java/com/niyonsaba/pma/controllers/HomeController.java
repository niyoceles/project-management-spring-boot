package com.niyonsaba.pma.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niyonsaba.pma.dto.ChartData;
import com.niyonsaba.pma.dto.EmployeeProject;
import com.niyonsaba.pma.entities.Employee;
import com.niyonsaba.pma.entities.Project;
import com.niyonsaba.pma.services.EmployeeService;
import com.niyonsaba.pma.services.ProjectService;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("")
	public String displyHomePage(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);
		
//		Status of project
        List<ChartData> projectData = projectService.getProjectStatus();
//        let convert projectData object into a json structure;
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        String jsonstring= objectMapper.writeValueAsString(projectData);
        
		model.addAttribute("projectStatus", jsonstring);
		
//		Get all projects
        List<Project> projects = projectService.getAll();	
		model.addAttribute("projectList", projects);
		
//		Get all employees
        List<Employee> employees = employeeService.getAll();
		model.addAttribute("employeesList", employees);
		
//		Employee with project  and number of project assigned
        List<EmployeeProject> employeesProjectCnt = employeeService.getEmployeeProject();
		model.addAttribute("employeesListProjectCnt", employeesProjectCnt);
		

		
		return "main/home";
    }
}
