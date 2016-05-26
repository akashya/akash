package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.org.mozilla.javascript.internal.ast.WhileLoop;


public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
  
    public UserHome() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		String user =(String) session.getAttribute("usersession");

		
		if(!session.isNew())
		{	
			try {
			
			
			
			out.println("<body bgcolor='silver'>");
			out.println("<center>"+"<img src='S1.jpg'/><div align='right'><a href='logout'>Logout</a></div><center>");
			
			out.println("<form action='SearchBook' method='get'>");
			out.println("<h4>Welcome : "+user+"</h4> ");
			out.println("</br></br>Search Book:"+"<input type='text' name='bookname'> </br></br>");
		    out.println("<input type='submit' name='search' value='search' >");
			out.println("</form>");	
			out.println("</div>");
			
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
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
