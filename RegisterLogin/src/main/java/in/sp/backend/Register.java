package in.sp.backend;

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
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	
	PrintWriter out = resp.getWriter();
      String myname = req.getParameter("name");
      String myemail = req.getParameter("email");
      String mypass = req.getParameter("pass");
      String Gender = req.getParameter("gender");
      String myCity = req.getParameter("city");
      
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3600/student", "root", "Sachin@123");

	PreparedStatement ps =con.prepareStatement("INSERT INTO register2 (name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)");
   ps.setString(1, myname);
   ps.setString(2,myemail);
   ps.setString(3, mypass);
   ps.setString(4, Gender);
   ps.setString(5, myCity);
   
   int count =ps.executeUpdate();
   if(count>0)
   {
	 resp.setContentType("text/html");
	 
	 out.print("<h3 style='color:green'>User registered successfully</h3>");
 
	   RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
   rd.include(req, resp);
   }
   else
   {
	   resp.setContentType("text/html");
		
	   out.print("<h3 style='color:green'>User not registered successfully</h3>");
   
		   RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
	   rd.include(req, resp);
   }
	}
	
	
	catch(Exception e)
	{
		e.printStackTrace();
		 resp.setContentType("text/html");
		
		 out.print("<h3 style='color:red'> Exception occur :"+e.getMessage() +"</h3>");

		   RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
	   rd.include(req, resp);	
	}
      
      
      
      
      
      
      
}
}
