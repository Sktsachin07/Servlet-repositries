package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	@Id
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="student_name")
	private String studentname;
	
	@Column(name="student_city")
	private String studentcity;

	
	public Student(int studentId, String studentname, String studentcity) {
		super();
		this.studentId = studentId;
		this.studentname = studentname;
		this.studentcity = studentcity;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentname() {
		return studentname;
	}


	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}


	public String getStudentcity() {
		return studentcity;
	}


	public void setStudentcity(String studentcity) {
		this.studentcity = studentcity;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentname=" + studentname + ", studentcity=" + studentcity
				+ "]";
	}


	public void setStudentId(String studentId2) {
		// TODO Auto-generated method stub
		
	}

}
