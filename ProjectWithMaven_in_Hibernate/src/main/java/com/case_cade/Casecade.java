package com.case_cade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Casecade {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new  Configuration().configure().buildSessionFactory();
		
		Session  s = factory.openSession();
		
		
		
		
		
		
		
		
	}
	
	
	

}
