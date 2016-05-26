package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddBook
 */
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AddBook() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String user =(String) session.getAttribute("usersession");
        
		if(!session.isNew())
		{
		 try {
			
			  String bname = request.getParameter("bname");
			  String author =request.getParameter("author");
			  double price = Double.parseDouble(request.getParameter("price"));
			
              Book b=new Book();
              int i=b.add(bname, author, price);
				
              if(i>0)
		         {
		        	 RequestDispatcher rd=request.getRequestDispatcher("InsertBook");
		        	 out.println("<center> Books is successfully Added </center>");
		        	 rd.include(request, response);
		        	 
		         }
              else
              {
            	  response.sendRedirect("InsertBook");
              }
				
		   } 
		   catch (Exception e) {
			
			response.sendRedirect("AdminHome");
			
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
