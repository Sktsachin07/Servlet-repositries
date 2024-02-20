package com.map1;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employ {
	
	@Id
	private int id;
	private String Ename;
	//@ManyToMany(mappedBy  = "employs")
	@ManyToMany(mappedBy = "emps" , cascade = CascadeType.ALL)


	List<Project> projects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProject(List<Project> project) {
		this.projects = projects;
	}

	public Employ(int id, String ename, List<Project> project) {
		super();
		this.id = id;
		Ename = ename;
		this.projects = projects;
	}

	public Employ() {
		super();
		// TODO Auto-generated constructor stub
	}
     
     
     
     
}
