package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removeData")
public class Delete extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	 resp.setContentType("text/html");

	PrintWriter out = resp.getWriter();
	
    String email =req.getParameter("email");
  
    
    try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3600/student", "root", "Sachin@123");

		PreparedStatement ps =con.prepareStatement("delete from register2 where email=? ");
	  
		 ps.setString(1,email);
	
		   
		   int count =ps.executeUpdate();
		   if(count>0)
		   {
			 resp.setContentType("text/html");
			 
			 out.print("<h3 style='color:green'>User details delete successfully</h3>");
		 
			   RequestDispatcher rd=req.getRequestDispatcher("/delete.jsp");
		   rd.include(req, resp);
		   }
		   else
		   {
			   resp.setContentType("text/html");
				
			   out.print("<h3 style='color:red'>User details delete error</h3>");
		   
				   RequestDispatcher rd=req.getRequestDispatcher("/delete.jsp");
		
				   
				  rd.include(req, resp);
		   }
			}
			
			
			catch(Exception e)
			{
				e.printStackTrace();
				 resp.setContentType("text/html");
				
				 out.print("<h3 style='color:red'> Exception occur :"+e.getMessage() +"</h3>");

				   RequestDispatcher rd=req.getRequestDispatcher("/delete.jsp");
			   rd.include(req, resp);	
			}
		      
		      
	

}
}

