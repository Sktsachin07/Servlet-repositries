package com.pegination;

import org.hibernate.query.*;

import com.tut.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPegination {

	public static void main(String[] args) {
		
	             SessionFactory   factory = new	Configuration().configure().buildSessionFactory();
	             Session s  = factory.openSession();
	             
	    Query<Student>  q1    =    s.createQuery("from Student ");
	    
	    
	       //  q1.setFirstResult(1);
	        
	         q1.setMaxResults(2);
	         
	         
	         List<Student> list =q1.list();
	         
	         for(Student x: list)
	         {
	        	 System.out.println(x.getId()+" : "+x.getName()+" : "+x.getCity());
	         }
	           
	            
	            
	            
	             
	             
	             
	             
	             
	     
	             
	             s.close();       
		
		   factory.close();
		
		
	}
	
	
	
}
