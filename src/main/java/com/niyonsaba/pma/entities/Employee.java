package com.niyonsaba.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_generator") //
	@SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
	private long employeeId;
	
	@NotNull
	@Size(min=2, max=30)
	private String firstName;
	
	@NotNull
	@Size(min=2, max=30)
	private String lastName;
	
	@NotNull
	@Email
	@Column(unique=true)
	private String email;
//	many employees could be assigned to one project
//	The best practice of Many to one
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, 
			fetch= FetchType.LAZY)
	@JoinTable(name="project_employee",
	joinColumns=@JoinColumn(name="employee_id"),
	inverseJoinColumns=@JoinColumn(name="project_id")
	)
	private List<Project> projects;
	
	public Employee() {
		
	}
	

	public List<Project> getProjects() {
		return projects;
	}



	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}





	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
