
package com.map2;

import javax.persistence.Entity;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class One_To_One_Map {

	  public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory  factory = cfg.buildSessionFactory();
		
		
		
		//creating Question
		Question  q1 = new Question();
		q1.setId(1212);
		q1.setQuestion("what is java ?");
		
		
	//	creating Answer
		
		Answer answer =new Answer();
		answer.setId(343);
		answer.setAnswer("java is programing language");
		q1.setAnswer(answer);
		
		
		
		//creating Question
		Question  q2 = new Question();
		q2.setId(1213);
		q2.setQuestion("what is collection framework ?");
		
		
	//	creating Answer
		
		Answer answer1 =new Answer();
		answer1.setId(344);
		answer1.setAnswer("Api to work with objects in java");
		q2.setAnswer(answer1);
		
		//session
		Session s = factory.openSession() ;
		
		Transaction tx = s.beginTransaction();
		
		//save
		s.save(q1);
		s.save(answer);
		s.save(q2);
		s.save(answer1);
		
		
		tx.commit();
		
		
		// fetch
		Question newQ = (Question) s.get(Question.class, 1212);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());
		
		s.close();
		
		factory.close();
		System.out.println("done....!");
	}
	
}
