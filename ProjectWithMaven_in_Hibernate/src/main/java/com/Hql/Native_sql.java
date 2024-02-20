  package com.Hql;

import java.util.Arrays;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class Native_sql {

	public static void main(String[] args) {

	//	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	//	Session s = factory.openSession();


		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session s = factory.openSession();


		// SQL QUERY

		String q = ("select * from student");
	         NativeQuery nq = s.createSQLQuery(q);                   //native :- Native Query refers to actual SQL queries (referring to actual database objects).
                                                                    // These queries are the SQL statements that can be directly executed in the database using a database client.
                                                                    // These have the standard SQL syntax that is specific to the database system.

	         
	         List<Object[]> l1 = nq.list();
	         
	         for(Object[] x : l1)
	         {
	        	//System.out.println(Arrays.deepToString(x)); 
	        //	System.out.println();
	        	System.out.println(x[4] + " : "+x[3]);
	         }


		s.close();
		factory.close();
		
		

	}

}
