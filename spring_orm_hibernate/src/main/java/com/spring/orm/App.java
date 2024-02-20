
package com.spring.orm;

import java.util.List;



import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
    ApplicationContext context =   new ClassPathXmlApplicationContext("springormcnf.xml");
    StudentDao studentDao =	context.getBean("studentDao", StudentDao.class);
 
   // dynamic (we can perform dynamically 
    
    
    
    int studentid=0;
  
    while(true)
   {
    System.out.println("________________________________________");
    System.out.println("what do you want to do");
    System.out.println("press 1 for insert");
    System.out.println("press 2 for Read");
    System.out.println("press 3 for read single details");
    System.out.println("press 4 for read single Student Details by Name");
    System.out.println("press 5 for Delete");
    System.out.println("press 6 for update");
    System.out.println("press 7 for exit");
    System.out.println("________________________________________");
    Scanner sc1 = new Scanner(System.in);
	
    Student student = new Student();

    try {	
	int ch=sc1.nextInt();
	
	
	switch(ch)
	{
	
	case 1:
	// Insert
	 System.out.println("Enter studentid");
	 student.setStudentId(sc1.nextInt());
	 sc1.nextLine();
	
	 System.out.println("Enter studentName");
	 student.setStudentname(sc1.nextLine());
	 //sc1.nextLine();
	 
	 System.out.println("Enter studentcity");
	 student.setStudentcity(sc1.nextLine());
     
     //System.out.println(student);
      studentDao.insert(student);
     System.out.println("done");
     break;
   
	
	case 2:
		// read all row 
		 List<Student> r1 = studentDao.getStudents();
	      for(Student x : r1)
	      {
	    	  System.out.println(x);
	      } 
	
	         break;
	
	
	case 3 :
		// read only one row
		 System.out.println("Enter student Id for gate Single student details");
     	int inputid = sc1.nextInt();
		 sc1.nextLine();
		 Student r = studentDao.getStudent(inputid);
		 System.out.println(r);
		  System.out.println("done");
		
          break;
	
	
	case  4:
	    System.out.println("Enter the datils you want to search the user with......!!");
		String Data=sc1.next();
		List<Student> student2 = studentDao.getStudent(Data);
		for (Student st : student2) 
		    {
			System.out.println(st);
		    }
		  System.out.println("suscces......!!");
          
	 break;
		
		
	case 5:
		//Delete
		System.out.println("Enter Student id for delete");
        studentid = sc1.nextInt();
		studentDao.deleteStudent(studentid);
		
		System.out.println("Delete sucess");
		break;
		
	
	case 6 :
		//update
		Student student1 = new Student();
      
	   System.out.println("Enter student id for update");
		student1.setStudentId(sc1.nextInt());
	   sc1.nextLine();
		System.out.println("Enter new name");
		student1.setStudentname(sc1.nextLine());
		
		System.out.println("Enter new city");
		student1.setStudentcity(sc1.nextLine());
	
	
		 studentDao.updateStudent(student1);
		
		
		System.out.println("update successful");
		break;
	
	
		
	case 7 :
		// exit
		  sc1.close();
          System.out.println("Exit success");
          System.exit(0);
          break; 
	
	}
     
   }
   
   catch(Exception e)
   {
	   System.out.println("========================================================");
	   System.out.println("YOUR ENTITY IS NOT VALID !! , PLEASE PROVIDE VALIAD ID");
	   System.out.println("========================================================");
	  
   }
     
   
 //================================================================================================
   // static (not user given by user we are doing direct)
  /*  
   * 
   *  // insert data
	  Student student = new Student(104,"Vivek Kumar ","pune");
	  
	 int r = studentDao.insert(student); 
	  System.out.println("done = "+r); */
	 
    
   
	
    /*
	  // get only one row 
	 
	  Student r = studentDao.getStudent(101);
	  System.out.println(r);
	 */
    
    
 
    /*  // get All row
     List<Student> r = studentDao.getStudents();
      for(Student x : r)
      {
    	  System.out.println(x);
      }   */
     
   
 /*  // Delete
    studentDao.deleteStudent(102);
    System.out.println("delete success");
    */
    
    // update
       
      
    
//========================================================================================================
    
    }
    }
}
