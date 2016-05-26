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

public class ShowDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null;  
    public ShowDetail() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String user =(String) session.getAttribute("usersession");
        
		if(!session.isNew())
		{		
		      try {
				  ConnectionDB cd = new ConnectionDB();
				  con = cd.connect();
				  PrintWriter out=response.getWriter();
				  String bname=request.getParameter("bname"); 
				  String Query = "select * from book where bname='"+bname+"'";                 // delete Query
				  Statement st = con.createStatement();
				 
				  ResultSet rs = st.executeQuery(Query);
				
				  out.println("<body bgcolor='silver'>");
				  out.println("<center>"+"<img src='S1.jpg'/><div align='right'><a href='logout'>Logout</a></div><center>");
				  out.println("<form >");
				  out.println("<h1>WELOCME TO CYBAGENET</h1>");
				  while(rs.next())
				  {
					 out.println("</br><table>");
			         
					 out.println("<tr><td>Book Id:</td>");
				     out.println("<td><input type='text' name='bid' value='"+rs.getInt(1)+"'readonly=''></td></tr>");
				    
					 out.println("<tr><td>Book Name:</td>");
				     out.println("<td><input type='text' name='bname' value='"+rs.getString(2)+"'readonly=''></td></tr>");
				   
				     out.println("<tr><td>Author:</td>");
					 out.println("<td><input type='text' name='author' value='"+rs.getString(3)+"'readonly=''></td></tr>");
	                
	                 out.println("<tr><td>Price:</td>");
	  			     out.println("<td><input type='text' name='price' value='"+rs.getDouble(4)+"'readonly=''></td></tr>");
				     
					 out.println("</table>");
					 out.println("</form >");
					 
					 out.println("<center>");
					 out.println("<a href='UserHome'>Back to Home</a>");
					 out.println("</center>");
					 out.println("</div>");	
				  }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		}
		else
		{
			response.sendRedirect("Home.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
