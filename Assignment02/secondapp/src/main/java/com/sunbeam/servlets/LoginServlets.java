package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/login")
public class LoginServlets extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		
		try(UserDao userDao = new UserDaoImpl()){
			
			User dbUser = userDao.findByEmail(email);
			
			if(dbUser != null && dbUser.getPassword().equals(password)) {
				Cookie c1 = new Cookie("uname", dbUser.getFirstName());
				c1.setMaxAge(600);
				resp.addCookie(c1);
				
				Cookie c2 = new Cookie("role",dbUser.getRole());
				resp.addCookie(c2);
				c2.setMaxAge(600);
				if(dbUser.getRole().equals("admin")) {
					resp.sendRedirect("result");
				}
				else {
					resp.sendRedirect("candidatelist");
				}
			}
		
		else {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();	
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> LoginInvalid </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Invalid User</h1>");
		out.println("<p>Sorry , Invalid user name or password you may try it again</p>");
		out.println("<a href='index.html' value=\"Login-Page\"></a>");
		out.println("</body>");
		out.println("</html>");
		
		}
	} catch (Exception e) {
		e.printStackTrace();
		throw new ServletException();	}
	}
	

}
