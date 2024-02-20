package com.tut;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class student_certificate {

	public static void main(String[] args) {
		

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
       
        SessionFactory factory = cfg.buildSessionFactory();
	//student 1 detalis
	Student student1 =new Student();
	student1.setId(14134);
	student1.setName("sachin kumar");
	student1.setCity("kolkata");
	
	
	 Certificate certificate1 =new Certificate();
	 certificate1.setCourse("Andriod");
	 certificate1.setDuration("2 months");
	 
	 student1.setCerti(certificate1);
	
	 //student 2 details
	 Student student2 =new Student();
		student2.setId(14135);
		student2.setName("Rohit kumar");
		student2.setCity("mumbai");
	
	  Certificate certificate2 =new Certificate();
		 certificate2.setCourse("hibernate");
		 certificate2.setDuration("1.5 months");
	
		 student2.setCerti(certificate2);
		 System.out.println(student1);
		 
		 
		//student 3 detalis
			Student student3 =new Student();
			student3.setId(130);
			student3.setName("Rahul kumar");
			student3.setCity("kolkata");
			
			
			 Certificate certificate3 =new Certificate();
			 certificate3.setCourse("java");
			 certificate3.setDuration("2 months");
			 
			 student3.setCerti(certificate3);
			
			 //student 4 details
			 Student student4 =new Student();
				student4.setId(131);
				student4.setName("Mohit kumar");
				student4.setCity("pune");
			
			  Certificate certificate4 =new Certificate();
				 certificate4.setCourse("hibernate");
				 certificate4.setDuration("1.5 months");
			
				 student4.setCerti(certificate4);
				 //System.out.println(student3);
	
		          Session s = factory.openSession();
	              Transaction tx = s.beginTransaction();
		
	              s.save(student1);
	              s.save(student2);
	              s.save(student3);
	              s.save(student4);
	              
		          tx.commit();
	              s.clear();
		          factory.close();
	
	
	}
}
