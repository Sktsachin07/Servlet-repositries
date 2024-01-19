package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet

{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
    PrintWriter   out = resp.getWriter();
	String myname =	req.getParameter("name");
       String email  = 	req.getParameter("email");
	   String mypass =  req.getParameter("pass");
	   String mygender = req.getParameter("gender");
	   String mycity =   req.getParameter("city");
	
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3600/student", "root", "Sachin@123");
	       PreparedStatement ps = con.prepareStatement("INSERT INTO register2 (name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)");
	       ps.setString(1, myname);
	       ps.setString(2, email);
	       ps.setString(3, mypass);
	       ps.setString(4, mygender);
	       ps.setString(5, mycity);
	   
	       int count = ps.executeUpdate();
	       if(count >0 )
	       {
	    	   resp.setContentType("text/html");
	    	   out.print("<h2 style= 'color:green'> User registered successfully </h2>");
	    	   
	    	   RequestDispatcher rd =req.getRequestDispatcher("/register.jsp");
	           rd.include(req, resp);
	           
	           
	           }
	       else
	       {
	    	   resp.setContentType("text/html");
	    	   out.print("<h2 style= 'color:red'> User registered  not register </h2>");
	    	   
	    	   RequestDispatcher rd =req.getRequestDispatcher("/register.jsp");
	           rd.include(req, resp);
	       }
	   
	   }
	catch(Exception e)
	   {
		
		
	 e.printStackTrace();
		 resp.setContentType("text/html");
  	   out.print("<h2 style= 'color:red'> Exception : " + e.getMessage() + "</h2>");
  	   
  	   RequestDispatcher rd =req.getRequestDispatcher("/register.jsp");
         rd.include(req, resp);
	   
	   
	   
	   
	   
	   
	   }
	
}
}
