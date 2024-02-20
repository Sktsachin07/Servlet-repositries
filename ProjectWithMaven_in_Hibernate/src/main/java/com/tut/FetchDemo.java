package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args) {
		
		// get, load
		
		
		 Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml"); 
		 SessionFactory factory = cfg.buildSessionFactory();
		 Session session =factory.openSession();
		 
		 //get-student 
		 Student student =(Student)session.get(Student.class, 101);
		 System.out.println(student);
		 
		 
		Address add =(Address) session.get(Address.class, 1);
		 System.out.println(add.getCity());
		 
		 Address add1 =(Address)session.get(Address.class, 1);
		 System.out.println("cicty : "+add1.getCity()+" , date :  "+add1.getDateadd());
		 
		 session.close(); 
		 factory.close();
	}

}
