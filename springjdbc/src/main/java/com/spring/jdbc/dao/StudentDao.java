package com.spring.jdbc.dao;
// Dao== data access object
 


import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentId);
	//public List<Student>  getAllStudent(); 
	public Student getStudent(int Id);
	public List<Student> getStudent();
	
 
}
 