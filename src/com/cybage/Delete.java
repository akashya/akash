package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Delete() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 PrintWriter out=response.getWriter();
		 out=response.getWriter();
		
		 out.println("<center>");
		 out.println("<body bgcolor='silver'>");
	     out.println("<center>"+"<img src='S1.jpg'/><div align='right'><a href='logout'>Logout</a></div><center>");
		 out.println("<form action='DeleteBook' method='get'>");
		 out.println("<input type='text' name='bname' >");
		 out.println("<input type='submit' name='Delete' value='Delete' >");
		 out.println("</form>");
		 out.println("</br><a href='AdminHome'>Back to Home</a>");
		 out.println("</center>");
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
