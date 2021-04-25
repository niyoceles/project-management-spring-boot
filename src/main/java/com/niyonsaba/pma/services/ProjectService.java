package com.niyonsaba.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niyonsaba.pma.dao.ProjectRepository;
import com.niyonsaba.pma.dto.ChartData;
import com.niyonsaba.pma.entities.Project;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
		
	}
	
	public List<Project> getAll() {
		return proRepo.findAll();
		
	}
	
	public List<ChartData> getProjectStatus() {
		return proRepo.getProjecstatus();
		
	}

}
