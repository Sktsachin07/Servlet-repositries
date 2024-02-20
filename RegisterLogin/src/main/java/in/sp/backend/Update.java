package in.sp.backend;


import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateUserServlet")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        //========================================
        
        
        response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	
    	
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3600/student", "root", "Sachin@123");

    		PreparedStatement ps =con.prepareStatement("select * from register2 where email=? and password=?");
    	    ps.setString(1, email );
    	    ps.setString(2, password);
    	   
    	   ResultSet rs = ps.executeQuery();
    	  
    	   if(rs.next())
    	   {
    		   HttpSession session =request.getSession();
    		   session.setAttribute("session_name",rs.getString("name") );
    		   session.setAttribute("session_email" ,rs.getString("email"));
    		   session.setAttribute("session_gender" ,rs.getString("gender"));
    		   session.setAttribute("session_city" ,rs.getString("city"));
    		   
    	   }
    	   else
    	   {
    		   
    		   out.print("<h3 style='color:red'> Email id and password did not matched </h3>");
    		   System.exit(0);
    		   
    	   
    	   }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        
        
      //  =======================================

        // Fetch the existing values from the database
        String existingName = "";
        String existingGender = "";
        String existingCity = "";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // JDBC connection code (replace with your database details)
            String jdbcUrl = "jdbc:mysql://localhost:3600/student";
            String dbUser = "root";
            String dbPassword = "Sachin@123";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            // Query to fetch existing values based on email
            String selectQuery = "SELECT name, gender, city FROM register2 WHERE email=?";
            stmt = conn.prepareStatement(selectQuery);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            // Check if the email exists in the database
            if (rs.next()) {
                existingName = rs.getString("name");
                existingGender = rs.getString("gender");
                existingCity = rs.getString("city");
            } else {
                response.setContentType("text/html");
                out.println("<html><body><p>Email not found in the database.</p></body></html>");
                return;
            }

            // Update values based on user input
            if (name == null || name.isEmpty()) {
                name = existingName;
            }
            if (gender == null || gender.isEmpty()) {
                gender = existingGender;
            }
            if (city == null || city.isEmpty()) {
                city = existingCity;
            }

            // Perform the update in the database
            String updateQuery = "UPDATE register2 SET name=?, gender=?, city=? WHERE email=?";
            stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setString(2, gender);
            stmt.setString(3, city);
            stmt.setString(4, email);
            int rowsAffected = stmt.executeUpdate();

            response.setContentType("text/html");
            if (rowsAffected > 0) {
                out.println("<html><body><p>Update successful!</p></body></html>");
            } else {
                out.println("<html><body><p>Update failed. Please try again.</p></body></html>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    	}
}
 