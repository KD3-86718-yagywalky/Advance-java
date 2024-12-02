package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profileServlet")
public class ProfileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Home</title>");
		out.println("</head>");
		out.println("<body style=\"background-color: black; color: white\">");
		out.println("<h1>	This is 1st Assignment of Advance java </h1>");
		out.println("<br/>\r\n"
				+ "<br/>");
		out.println("<h4>First Name : Yagywalky</h4>");
		out.println("<h4>Last Name : Dubey</h4>");
		out.println("<h4>Qualification : B.Tech</h4>");
		out.println("<h4>College Name : Madhav Institute of Technology and Science </h4>");
		out.println("<h4>Birth Date : 15/11/2001</h4>");
		out.println("</body>");
		out.println("</html>");
	}
}
