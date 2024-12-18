package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Accn")
public class Announcement extends HttpServlet{
	
	private static final long serialVersionUID = 1;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String add = req.getParameter("ann");
		
		ServletContext sq = this.getServletContext();
		sq.setAttribute("announcement", add);
		
		resp.sendRedirect("result");
	}
	
}

