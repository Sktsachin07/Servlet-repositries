package com.map1;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class many_To_many_map
{
  public static void main(String[] args) {
	
	  Configuration cfg = new Configuration();
	  cfg.configure("hibernate.cfg.xml");
	  SessionFactory  factory =  cfg.buildSessionFactory();
	  
	  
	  Employ e1 = new Employ();
	  e1.setId(151);
	  e1.setEname("Ram");
	  
	  Employ e2 =new Employ();
	  e2.setId(161);
	  e2.setEname("Sohan");
	  
	  
	  Project p1 =new Project();
	  p1.setId(0001111);
	  p1.setProject_name("school Management");
	  
	  Project p2 = new Project();
	  p2.setId(0003333);
	  p2.setProject_name("Car Parking");
	  
	  
	  List<Employ> l1 = new ArrayList<Employ>(); 
	  List<Project> l2 = new ArrayList<Project>();
	  
	  l1.add(e1);
	  l1.add(e2);
	  
	  
	  l2.add(p1);
	  l2.add(p2);
	  
	  
	  //
	  
	  e1.setProject(l2);
	  p2.setEmp(l1);
	  
	  
	  
	  Session  s = factory.openSession();
	  Transaction tx = s.beginTransaction();
	  
	  
	  
	  s.save(e1);
	  s.save(e2);
	  s.save(p1);
	  s.save(p2);

	
	  
	  
	
	  
	  tx.commit();
	 s.close(); 
	factory.close();
	
}
	
	
	
	
}
