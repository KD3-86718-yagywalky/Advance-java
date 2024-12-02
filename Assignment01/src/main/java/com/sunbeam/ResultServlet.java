package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resultServlet")
public class ResultServlet extends HttpServlet{
	
	ArrayList<Marks> result;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		result = new ArrayList<Marks>();
		
		result.add(new Marks("Java programming", 80.0)); 
	    result.add(new Marks("Web programming", 85.0)); 
	    result.add(new Marks("Database technologies", 83.0)); 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		 out.println("<html>");
			out.println("<head>");
			out.println("<title>Home</title>");
			out.println("</head>");
			out.println("<body style=\"background-color: black; color: white\">");
			out.println("<h1>	Student Makrs information</h1>");
			out.println("<br/>\r\n"
					+ "<br/>");
		 for(Marks m:result) { 
			
			 	out.println("<table style=\"border: solid;\">");
			    out.println("<tr>"); 
			    out.printf("<td><h2>%s</h2><td>\r\n", m.getSubject()); 
			    out.printf("<td><h2>%.2f<h2><td>\r\n", m.getMarks()); 
			    out.println("</tr>"); 
			    out.println("</table>");
			    
			}

		    out.println("</body>");
			out.println("</html>");
		
		
	}
	
	
}
