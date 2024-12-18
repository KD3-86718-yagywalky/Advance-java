package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/result")
public class ResultServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Candidate> list = new ArrayList<>();
		
		try( CandidateDao candDao = new CandidateDaoImpl()){
			list = candDao.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		ServletContext cr = this.getServletContext();
		String app = cr.getInitParameter("background-color");
		
		out.printf("<body bgcolor = '%s'>", app);
		
ServletContext ctx = this.getServletContext();
		
		String appTitle = ctx.getInitParameter("app.title");
		
		out.printf("<h1>%s</h1>", appTitle);
		
		ServletContext sq = req.getServletContext();
		
		String annc = (String) sq.getAttribute("announcement");
		
		if( annc != null) {
			out.println("<p style='color:red'> NOTE: " + annc + "</p>");
		}
		Cookie[] arr = req.getCookies();
		
		String userName = "", role="";
		
		if(arr !=null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname")) {
					userName = c.getName();
				}
				if(c.getName().equals("role"))
					role=c.getValue();
			}
		}
		out.println("<h2>Voting Result</h2>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(Candidate c : list) {
		out.println("<tr>");
		out.printf("<td>%d</td>\n", c.getId());
		out.printf("<td>%s</td>\n", c.getName());
		out.printf("<td>%s</td>\n", c.getParty());
		out.printf("<td>%d</td>\n", c.getVotes());
		out.printf("<td> \n");
		out.printf("<a href='editcand?id=%d'><img src='image/edit.png' alt='Edit' width='24' height='24'></img></a>\n", c.getId());
		out.printf("<a href='delete?id=%d'><img src='image/delete.png' alt='Delete' width='24' height='24'></img></a>\n", c.getId());
		out.printf("<td> \n");
		out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		
		String massege = (String) req.getAttribute("msg");
		if (massege != null) {
			out.println("<p>"+ massege +"</p>");
		}
		
		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("<p><a href='registrationcandidate'>Add Candidate</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

}
