package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/editcand")
public class EditCandidate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id = Integer.parseInt(req.getParameter("id"));
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit</title>");
		out.println("</head>");	
		ServletContext cr = this.getServletContext();
		String app = cr.getInitParameter("background-color");
		
		out.printf("<body bgcolor = '%s'>", app);
		ServletContext ctx = this.getServletContext();
		
		String appTitle = ctx.getInitParameter("app.title");
		
		out.printf("<h1>%s</h1>", appTitle);
		out.println("<h2>Edit Candidate</h2>");
		
		try(CandidateDao candDao = new CandidateDaoImpl()){
			
		Candidate c =candDao.findById(id);
	
		if(c != null) {
			
			out.println("<form method='post' action='editcand'>");
			out.printf("Id: <input type='text' name='id' value='%d' readonly/><br/>\n", c.getId());
			out.printf("Name: <input type='text' name='name' value='%s'/><br/>\n", c.getName());
			out.printf("Party: <input type='text' name='party' value='%s'/><br/>\n", c.getParty());
			out.printf("Votes: <input type='text' name='votes' value='%d' readonly/><br/><br/>\n", c.getVotes());
			out.println("<input type='submit' value='Update Candidate'/>");
			out.println("</form>");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		out.println("</body>");	
		out.println("</html>");	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String Name = req.getParameter("name");
		String Party = req.getParameter("party");
		int Votes = Integer.parseInt(req.getParameter("votes"));
		
		Candidate cand = new Candidate(id, Name, Party, Votes);
		
		try(CandidateDao candao = new CandidateDaoImpl()){
			
			int count = candao.update(cand);
			String massege = "Candidate Massege : " + count;
			req.setAttribute("msg", massege);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("result");
		rd.forward(req, resp);
	}
			
	
	
	

}
