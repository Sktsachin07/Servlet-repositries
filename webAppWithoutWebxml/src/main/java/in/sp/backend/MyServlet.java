package in.sp.backend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aaa")
public class MyServlet extends HttpServlet
{

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	System.out.println("i am in MyServletMethod");
}
}
