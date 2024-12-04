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

@WebServlet("/candidatelist")
public class CandilateList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Candidate> candilist = new ArrayList<>();
		
		try(CandidateDao candDao = new CandidateDaoImpl()){
			
			candilist = candDao.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(); 
		}
		
			resp.setContentType("text/html");
			
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Candidate List</title>");
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
			
			out.printf("Hello, %s (%s)<hr/> \n",userName, role);
					
			out.println("<h2>Candidate List</h2>");
			out.println("<form mehtod='post' action='vote'>");
			for (Candidate c : candilist) {
				
				out.printf("<input type='radio' name='candidate' value='%d'/> %s <br/>\n ", c.getId(),c.getName());	
			}
			
			out.println("<input type='submit' value='Vote'/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		
	}
	
	

}