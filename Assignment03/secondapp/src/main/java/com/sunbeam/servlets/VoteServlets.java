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
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

@WebServlet("/vote")
public class VoteServlets extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String candId = req.getParameter("candidate");
		int id = Integer.parseInt(candId);
		
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
		
		HttpSession session = req.getSession(false);
		
		if(session == null) {
			resp.sendError(440, "Session terminated");
		}
		User user = (User) session.getAttribute("candname");
		
		if(user.getStatus()==0) {
		
		out.printf("Hello , %s (%s) <hr/>\n",userName,role);
		out.println("<h2>Voting Status</h2>");
		
		try(CandidateDao candDao = new CandidateDaoImpl()){
			
			int count = candDao.IncrVote(id);
			if(count == 1) {
				out.println("<h4>You have successfully casted your vote.</h4>");
				user.setStatus(1);
				try(UserDao userdao = new UserDaoImpl()){
					count = userdao.update(user);
					if(count==1) {
						out.println("<h4>You are marked as voted</h4>");
					}
				}
			}
			else
				out.println("<h4>Your voting failed.</h4>");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		}
		else {
			out.println("<h4>You have Already voted successfully </h4>");
		}
		
		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	


}