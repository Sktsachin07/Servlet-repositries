package com.spring.jdbc;

import java.util.List;


import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;



public class App  
{
    public static void main( String[] args )
    {
        System.out.println( "project start" );
        
        ApplicationContext context =new ClassPathXmlApplicationContext("com/spring/jdbc/spring.confi.xml");
       
        
		/*
		 * JdbcTemplate templete = context.getBean("jdbcTemplate",JdbcTemplate.class);
		 * String query = "insert into student(id,name,city) value (?,?,?)";
		 *  int result = templete.update(query,105,"Ranjan kumar","Bhopal");
		 * System.out.println("successful"+ " : "+result);
		 */
 StudentDao studentdao =  context.getBean("studentDao",StudentDao.class);
    
 
	/*   // for inserting
	 *
	 * Student student =new Student(); 
	 * student.setId(110);
	 * student.setName("prakash kumar 12"); 
	 * student.setCity("Bhopal");
	 * 
	 * int result = studentdao.insert(student);
	 * System.out.println("student added"+" : " + result );
	 */
 
	
 /*
	 * // for updating 
	 * Student student =new Student(); 
	 * student.setId(103);
	 * student.setName("Raviranjan kumar"); 
	 * student.setCity("ujjain"); 
	 * int result =
	 * studentdao.change(student);
	 * System.out.println("update successful"+" : "+result);
	 */
    
   
 
	/*
	 * // for Delete
	 * 
	 * int result = studentdao.delete(102);
	 * System.out.println("delete susscessful : "+result);
	 */
  
 
	/*
	 * // for read one details 
	 * Student student = studentdao.getStudent(101);
	 * System.out.println(student);
	 */
   
 // read all details
 List<Student> student1 = studentdao.getStudent();
		 
		for(Student x : student1)
		{
			System.out.println(x);
		}

 
    
    
    }
}
