package com.niyonsaba.pma.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niyonsaba.pma.dao.EmployeeRepository;
import com.niyonsaba.pma.dao.ProjectRepository;
import com.niyonsaba.pma.dto.ChartData;
import com.niyonsaba.pma.dto.EmployeeProject;
import com.niyonsaba.pma.entities.Employee;
import com.niyonsaba.pma.entities.Project;


@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("")
	public String displyHomePage(Model model) throws JsonProcessingException {
		
		Map<String, Object> map = new HashMap<>();
		
//		Status of project
        List<ChartData> projectData = proRepo.getProjecstatus();
//        let convert projectData object into a json structure;
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        String jsonstring= objectMapper.writeValueAsString(projectData);
        
		model.addAttribute("projectStatus", jsonstring);
		
//		Get all projects
        List<Project> projects = proRepo.findAll();	
		model.addAttribute("projectList", projects);
		
//		Get all employees
        List<Employee> employees = employeeRepo.findAll();
		model.addAttribute("employeesList", employees);
		
//		Employee with project  and number of project assigned
        List<EmployeeProject> employeesProjectCnt = employeeRepo.employeeProjects();
		model.addAttribute("employeesListProjectCnt", employeesProjectCnt);
		

		
		return "main/home";
    }
}
