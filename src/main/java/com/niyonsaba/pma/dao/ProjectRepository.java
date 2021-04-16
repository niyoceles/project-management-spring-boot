package com.niyonsaba.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.niyonsaba.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	@Override
	public List<Project> findAll();

}
