package in.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/aaa")
public class MyServlet extends HttpServlet
{

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
  PrintWriter out = resp.getWriter();
  out.println("sachin kumar Thakur");

}
}
