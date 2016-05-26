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

/**
 * Servlet implementation class InsertBook
 */
public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionDB cd = new ConnectionDB();
		PrintWriter out=response.getWriter();
		
		
	
		out.println("<center>");
		out.println("<body bgcolor='silver'>");
		out.println("<center>"+"<img src='S1.jpg'/><div align='right'><a href='logout'>Logout</a></div><center>");
		out.println("<form action='AddBook' method='get'>");
		
		out.println("<h4>Add the Book</h4><table>");
	
		out.println("<tr><td>Book Name:</td><td><input type='text' name='bname' required></td></tr>");	 
		out.println("<tr><td>Author:</td><td><input type='text' name='author'required></td></tr>");		
		out.println("<tr><td>Price:</td><td><input type='text' name='price' required></td></tr>");		
		out.println("<tr><td></td><td><input type='submit' name='add' value='ADD' ></td></tr></table>");		
		out.println("</form>");
		 out.println("</br><a href='AdminHome'>Back to Home</a>");
		out.println("</center>");
	
	
	    
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
