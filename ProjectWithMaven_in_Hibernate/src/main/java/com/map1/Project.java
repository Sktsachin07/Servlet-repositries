package com.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

@Id
@Column(name = "pid")
private int id;

@Column(name = "project_name")
private String projectName;

@ManyToMany
List<Employ> emps;
 

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getProjectName() {
	return projectName;
}

public void setProject_name(String project_name) {
	this.projectName = project_name;
}

public List<Employ> getEmp() {
	return emps;
}

public void setEmp(List<Employ> emps) {
	emps = emps;
}



public Project(int id, String projectName, List<Employ> emps) {
	super();
	this.id = id;
	this.projectName = projectName;
	this.emps = emps;
}

public Project() {
	super();
	// TODO Auto-generated constructor stub
}






}
