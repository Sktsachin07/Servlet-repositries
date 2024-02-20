package com.Hql;

import java.util.Arrays;



import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class exaplehql {
	
	public static void main(String[] args) {
		
		Configuration   cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
	
		Session s = factory.openSession();
		
		
		//HQL
		//syntax
		
		
		          
    //   String query ="from Student";                                     //for print all details     
		 String query= "from Student where name='sachin kumar'";                // for print details belong  this city 
	   //String query= "from Student where city=:x and name=:n";          // for print details belong city with this name
		
		
		Query   q = s.createQuery(query);
		
		/*q.setParameter("x", "gujrat");
		q.setParameter("n", "sachin kumar");*/
		
		List<Student> list =q.list();
		
		for(Student ss : list )
		{
			System.out.println(ss.getName()+" : "+ss.getCerti().getCourse());
			
		}   
		
	System.out.println("__________________________________________");
	
	

	  Transaction tx = s.beginTransaction();
	
	// delete
	  
	/*	Query q =s.createQuery("delete from Student where city=:c");
		
		q.setParameter("c","pune");
		int r= q.executeUpdate();
		System.out.println("delete succes");
		System.out.println(r);*/
		
     // update
	  
	/*  Query q1 =s.createQuery("update Student set city=:c  where name=:n");
		q1.setParameter("c","gujrat");
		q1.setParameter("n", "sachin kumar");
	int r1=	q1.executeUpdate();
	System.out.println(r1 +" update secces");*/
	  
	  
	  // how to execute join query 
	//  String query ="from Question_"; 
	  
	/*  Query q2= s.createQuery("select q.question,q.id,a.answer from Question_  as q INNER JOIN  q.answers as a" );
	  
	  List<Object[]> l1 =q2.getResultList();
	  for(Object[] x : l1)
	  {
		  System.out.println(Arrays.toString(x));
	  }
	*/
	    
	   tx.commit();
		s.close();
		factory.close();
	}

}
