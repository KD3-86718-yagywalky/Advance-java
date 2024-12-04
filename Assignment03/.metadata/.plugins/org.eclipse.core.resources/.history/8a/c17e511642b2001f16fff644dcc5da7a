package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

@WebServlet("/registrationcandidate")
public class RegistractionCandidateServlet extends HttpServlet{
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String Name = req.getParameter("name");
	String Party = req.getParameter("party");
	
	
	
	try(CandidateDao candi = new CandidateDaoImpl()){
		Candidate u = new Candidate(0, Name, Party, 0);
	int count =	candi.save(u);
	
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
