package com.map;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

   // import com.map2.Question;

public class One_to_Many {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		 
	
		//create question
        Question_ q1 = new Question_();
        q1.setId(121);
        q1.setQuestion("what is java");
        
        
        // create answer
        Answer_ answer = new Answer_();
        answer.setId(421);
        answer.setAnswer("java is programing language");
		answer.setQuestion(q1);
		
		
        Answer_ answer1 = new Answer_();
        answer1.setId(422);
        answer1.setAnswer("java is high level programing language");
        answer1.setQuestion(q1);
        
        
        Answer_ answer2 = new Answer_();
        answer2.setId(423);
        answer2.setAnswer("java is secure  programing language");
        answer2.setQuestion(q1);
        
		
        
        List<Answer_> list =new ArrayList<Answer_>();
        list.add(answer);
        list.add(answer1);
        list.add(answer2);
        q1.setAnswers(list);
//		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

	//	s.save(q1);
	
    Question_ q = (Question_) s.get(Question_.class,101);
       System.out.println(q.getQuestion());
    System.out.println(q.getId());
    System.out.println(q.getQuestion());
     
    //Lazy
    System.out.println(q.getAnswers().size());
    
    
    
     /*s.save(q1);
     s.save(answer1);
     s.save(answer);
     s.save(answer2);*/
//


/*
for(Answer_  a : q1.getAnswers())
{
	System.out.println(a.getAnswer());
}
		*/
		
		
		
		tx.commit();
		s.close();
		
		
		
		factory.close();
		
	}

}
