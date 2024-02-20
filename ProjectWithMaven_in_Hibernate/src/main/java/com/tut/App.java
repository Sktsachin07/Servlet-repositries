package com.tut;

import java.io.FileInputStream;


import java.util.Date;

import javax.xml.crypto.Data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )throws Exception
    {
        System.out.println( "project started" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");                /// configuration file name
      SessionFactory factory = cfg.buildSessionFactory();             //    only one will be SessionFactory for one project
                                                                     //    sessionFactory is interface and it will import
 
     
        
        //  System.out.println(factory);
       // System.out.println(factory.isClosed());
        
   
       Student st =new Student();   
       st.setId(101);
       st.setName("sohan");
       st.setCity("mumbai");
       System.out.println(st);
    
    
    Address ad =new Address();
    ad.setCity("Bihar");
    ad.setStreet("street1");
    ad.setIsopen(true);
    ad.setDateadd(new Date());
    ad.setX(5466.55);
    
   // Reading image
    FileInputStream fis =new FileInputStream("src/main/java/image.jpeg");
    byte[] data =new byte[fis.available()];
    fis.read(data);
	ad.setImg(data);
    
   Session session = factory.openSession();   
    Transaction tx = session.beginTransaction();
   
    session.save(st);
   session.save(ad);
   
    tx.commit();
    session.close();
    System.out.println("done.....!");
    
    }
    
}
