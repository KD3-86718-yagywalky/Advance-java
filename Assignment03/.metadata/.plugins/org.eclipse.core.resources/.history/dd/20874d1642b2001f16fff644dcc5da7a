package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/registrationuser")
public class RegistractionUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String First_Name = req.getParameter("first_name");
		String Last_Name = req.getParameter("last_name");
		String Email = req.getParameter("email");
		String password = req.getParameter("passwd");
		String DOB = req.getParameter("dob");
		
		Date d  = Date.valueOf(DOB);
		
		
		try(UserDao user = new UserDaoImpl()){
			User u = new User(0, First_Name, Last_Name, Email, password, d, 0, "voter");
		int count =	user.save(u);
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		out.println("<body>");
		if(count == 1)
			out.println("<h4>You have successfully casted your vote.</h4>");
		else
			out.println("<h4>Your voting failed.</h4>");
		out.println("<p><a href='index.html'>Login</a></p>");
		out.println("</body>");
		out.println("</html>");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException();
		}
		
		
 	}

}
