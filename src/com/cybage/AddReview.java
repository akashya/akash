package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null;    
   
    public AddReview() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 PrintWriter out=response.getWriter();
		 String bname=request.getParameter("bname");
		
		 HttpSession session=request.getSession();
		 String user =(String) session.getAttribute("usersession");
		 
		 if(!session.isNew())
		 {
			 out.println("<body bgcolor='silver'>");
			 out.println("<center>"+"<img src='S1.jpg'/><div align='right'><a href='logout'>Logout</a></div><center>");
		     out.println("<form action='Review' method='get'><center>");
	         out.println("<h4>Book Name:"+bname+"</br></br>");
		     out.println("<h2> ADD REVIEW</h2></br></br>");
		     out.println("<input type='hidden' name='bname' value='"+bname+"'>");
		     out.println("<input type='hidden' name='user' value='"+user+"'>");
		     out.println("Review:<input type='text' name='review' style='height:3cm ;width:15cm; 'required></br>");
		     out.println("<input type='submit' value='ADD'>");
		     out.println("</form></br>");
		     out.println("<a href='UserHome'>Back to Home</a>");
		    
		     out.println("</center></div>");
		 }
		 else
		 {
			 response.sendRedirect("Home.html");
		 }
	
	
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
