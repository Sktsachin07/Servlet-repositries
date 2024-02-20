package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.spring.jdbc.entities.Student;


public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	
	public int insert(Student student) {
		// query for insert
		 String query = "insert into student(id,name,city) value (?,?,?)";
		 int r1 = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity()) ; 
		
		return r1;
	}
   
	
	public int change(Student student) {
		//query for update
	 String query = "UPDATE student set name=?, city=? where id=?";
     int r2 = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId()) ; 
		
		return r2;
	}
	
	

public int delete(int studentId) {
	// query for delete
String query =  "DELETE from student where id=?";
 int r= this.jdbcTemplate.update(query,studentId);
  return r; 
}

		


public Student getStudent(int Id) {
	//query for Fatch single student
	String query = "select * from student where id=?";
	//	RowMapper<Student> rowMapper=new RowMapperImpl();
	 // Student student = this.jdbcTemplate.queryForList(query,rowMapper,Id);	
	RowMapper<Student> rowMapper = new RowMapperImpl();
	Student student =	this.jdbcTemplate.queryForObject(query, rowMapper,Id);
	
		return student;
}

	 
	

	
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
   public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


@Override
public List<Student> getStudent() {
	// TODO Auto-generated method stub
	return null;
}

} 




	






 





	
	


	

